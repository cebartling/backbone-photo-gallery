package cebartling.backbone.photogallery.controllers

import cebartling.backbone.photogallery.domain.Album
import cebartling.backbone.photogallery.domain.Photo
import grails.converters.JSON

import java.text.SimpleDateFormat

class PhotoController {

    private static final String DATE_FORMAT = 'MMMM d, yyyy'

    def index() { }

    def list() {
        log.info "Retrieving list of photos by album ${params.albumId}..."
        def album = Album.get(params.albumId)
        def formatter = new SimpleDateFormat(DATE_FORMAT)
        withFormat {
            js {
                def json = album.photos.collect { Photo photo ->
                    [
                            id: photo.id,
                            name: photo.name,
                            caption: photo.caption,
                            dateCreated: formatter.format(photo.dateCreated)
                    ]
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
