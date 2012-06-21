package cebartling.backbone.photogallery.controllers

import cebartling.backbone.photogallery.domain.Album
import cebartling.backbone.photogallery.domain.Photo
import grails.converters.JSON

class PhotoController {

    def index() { }

    def list() {
        log.info "Retrieving list of photos by album ${params.albumId}..."
        def album = Album.get(params.albumId)
        withFormat {
            js {
                def json = album.photos.collect { Photo photo ->
                    [id: photo.id, caption: photo.caption]
                }
                render(json as JSON)
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
