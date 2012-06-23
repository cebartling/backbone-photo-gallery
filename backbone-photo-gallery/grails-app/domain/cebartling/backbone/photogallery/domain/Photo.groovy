package cebartling.backbone.photogallery.domain

class Photo {

    static belongsTo = [album: Album]

    String name
    String caption
//    byte[] imageData
    Date dateCreated

    static constraints = {
        name(blank: false, nullable: false, maxSize: 80)
        caption(blank: true, nullable: true, maxSize: 4096)
//        imageData(nullable: false, maxSize: 4000000)
        dateCreated(nullable: false)
    }
}
