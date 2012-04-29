import cebartling.backbone.photogallery.domain.Profile
import cebartling.backbone.photogallery.domain.User

class BootStrap {

    def init = { servletContext ->

        User user = User.findByUsername('cebartling')
        if (!user) {
            user = new User(username: 'cebartling', password: 'pw123')
            def profile = new Profile(username: 'cebartling', fullName: 'Christopher Bartling', user: user)
            user.profile = profile

            user.save(validate: true, flush: true, failOnError: true)
        }


    }

    def destroy = {
    }

}
