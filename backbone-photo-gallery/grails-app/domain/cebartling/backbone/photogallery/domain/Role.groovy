package cebartling.backbone.photogallery.domain

class Role {

    static final String AUTHORITY_USER = 'AUTHORITY_USER'

    String authority

    static mapping = {
        cache true
    }

    static constraints = {
        authority blank: false, unique: true
    }
}
