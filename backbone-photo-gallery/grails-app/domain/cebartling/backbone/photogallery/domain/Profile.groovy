package cebartling.backbone.photogallery.domain

class Profile {

    String username
    String password
    String fullName


    static constraints = {
        username(blank: false, nullable: false, size: 4..25)
        password(blank: false, nullable: false, size: 4..25)
        fullName(blank: false, nullable: false, size: 4..80)
    }
}
