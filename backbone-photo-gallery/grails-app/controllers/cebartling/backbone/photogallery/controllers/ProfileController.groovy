package cebartling.backbone.photogallery.controllers

import cebartling.backbone.photogallery.domain.Profile

class ProfileController {

    def index() {
        def profiles = Profile.list()
        withFormat {
            js {
                render profiles
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
