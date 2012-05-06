package cebartling.backbone.photogallery.controllers

import cebartling.backbone.photogallery.domain.Profile
import grails.converters.JSON
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class ProfileController {

    static defaultAction = "index"

    def springSecurityService

    def index() {
        def user = springSecurityService.currentUser
        def profile = Profile.findByUser(user)
        render view: 'index', model: [profile: profile]
    }

    def list() {
        log.info "Retrieving list of profiles..."
        def profiles = Profile.list()
        withFormat {
            js {
                def json = profiles.collect { Profile profile ->
                    [id: profile.id, fullname: profile.fullName, username: profile.username]
                }
                render(json as JSON)
            }
        }
    }

    def show() {
        log.info "Retrieving profile by id: ${params.id}."
        def profile = Profile.get(params.id)
        withFormat {
            js {
                render([id: profile.id,
                        fullname: profile.fullName,
                        username: profile.username] as JSON)
            }
        }
    }

    def update() {

    }

    def delete() {

    }

    def save() {

    }
}
