package cebartling.backbone.photogallery.controllers

import cebartling.backbone.photogallery.domain.Album
import cebartling.backbone.photogallery.domain.Profile
import grails.converters.JSON

class AlbumController {

    def index() { }

    def list() {
        log.info "Retrieving list of albums by profile ${params.profileId}..."
        def profile = Profile.get(params.profileId)
        withFormat {
            js {
                def json = profile.albums.collect { Album album ->
                    [id: album.id, name: album.name]
                }
                render(json as JSON)
            }
        }
    }

    def show() {
//        log.info "Retrieving profile by id: ${params.id}."
//        def profile = Profile.get(params.id)
//        withFormat {
//            js {
//                render([id: profile.id,
//                        fullname: profile.fullName,
//                        username: profile.username] as JSON)
//            }
//        }
    }

    def update() {

    }

    def delete() {

    }

    def save() {

    }

}
