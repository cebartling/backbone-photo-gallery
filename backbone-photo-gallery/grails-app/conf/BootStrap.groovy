import cebartling.backbone.photogallery.domain.*

class BootStrap {

    def init = { servletContext ->

        Role role = Role.findByAuthority('ROLE_USER')
        if (!role) {
            role = new Role(authority: 'ROLE_USER')
            role.save(validate: true, flush: true, failOnError: true)
        }

        def username = 'cebartling'
        User user = User.findByUsername(username)
        if (!user) {
            user = new User(username: username, password: 'pw123', enabled: true)
            def profile = new Profile(username: username, fullName: 'Christopher Bartling', user: user)
            user.profile = profile
            user.save(validate: true, flush: true, failOnError: true)
            new UserRole(user: user, role: role).save(validate: true, flush: true, failOnError: true)

            createAlbums(profile)
        }


    }

    def createAlbums(Profile profile) {
        def album = new Album(profile: profile, name: 'Album 1', dateCreated: new Date())
        createPhotos(album)
        profile.addToAlbums(album)
        album = new Album(profile: profile, name: 'Album 2', dateCreated: new Date())
        createPhotos(album)
        profile.addToAlbums(album)
        album = new Album(profile: profile, name: 'Album 3', dateCreated: new Date())
        createPhotos(album)
        profile.addToAlbums(album)
    }

    void createPhotos(Album album) {
        album.addToPhotos(new Photo(name: 'Photo 1', caption: 'Something kinda funny...', dateCreated: new Date()))
        album.addToPhotos(new Photo(name: 'Photo 2', caption: 'Something kinda sad...', dateCreated: new Date()))
        album.addToPhotos(new Photo(name: 'Photo 3', caption: 'Something kinda queer...', dateCreated: new Date()))
        album.addToPhotos(new Photo(name: 'Photo 4', caption: 'Something kinda weird...', dateCreated: new Date()))
    }

    def destroy = {
        def username = 'cebartling'
        User user = User.findByUsername(username)
        if (user) {
            user.profile.delete()
            user.delete()
        }

    }

}
