package cebartling.backbone.photogallery.domain

class Profile {

    User user
    static belongsTo = [user: User]

    List<Album> albums
    static hasMany = [albums: Album]

    String username
    String fullName


    static constraints = {
        user(nullable: false)
        username(blank: false, nullable: false, size: 4..25)
        fullName(blank: false, nullable: false, size: 4..80)
    }
}
