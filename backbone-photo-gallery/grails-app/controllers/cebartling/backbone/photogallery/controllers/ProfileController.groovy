package cebartling.backbone.photogallery.controllers

import cebartling.backbone.photogallery.domain.Profile
import grails.converters.JSON

class ProfileController {

    def index() {
        log.info "Retrieving list of profiles..."
        def profiles = Profile.list()
        withFormat {
            js {
                def json = profiles.collect { Profile profile ->
                    [id: profile.id, fullname: profile.fullName, username: profile.username]
                }
                render json as JSON
            }
        }
    }

    def show() {

    }

    def update() {

    }

    def delete() {

    }

    def save() {

    }
}
