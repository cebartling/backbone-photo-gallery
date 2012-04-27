import cebartling.backbone.photogallery.domain.Profile

class BootStrap {

    def init = { servletContext ->

        new Profile(username: 'cebartling', password: 'pw123', fullName: 'Christopher Bartling')
                .save(validate: true, flush: true, failOnError: true)

        new Profile(username: 'krbartling', password: 'pw123', fullName: 'Kurt Bartling')
                .save(validate: true, flush: true, failOnError: true)

        new Profile(username: 'kabartling', password: 'pw123', fullName: 'Kari Bartling')
                .save(validate: true, flush: true, failOnError: true)

    }

    def destroy = {
    }

}
