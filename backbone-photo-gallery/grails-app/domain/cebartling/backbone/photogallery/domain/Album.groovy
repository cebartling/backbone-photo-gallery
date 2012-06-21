package cebartling.backbone.photogallery.domain

class Album {

    static belongsTo = [profile: Profile]

    List<Photo> photos
    static hasMany = [photos: Photo]

    String name
    Date dateCreated

    static constraints = {
        name(blank: false, nullable: false, maxSize: 1024)
        dateCreated(nullable: false)
        profile(nullable: false)
    }
}
