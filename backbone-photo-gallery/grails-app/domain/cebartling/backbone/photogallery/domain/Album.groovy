package cebartling.backbone.photogallery.domain

class Album {

    static belongsTo = [profile: Profile]

    String name
    Date dateCreated

    static constraints = {
        name(blank: false, nullable: false, maxSize: 1024)
        dateCreated(nullable: false)
        profile(nullable: false)
    }
}
