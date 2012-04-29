import cebartling.backbone.photogallery.domain.Profile
import cebartling.backbone.photogallery.domain.Role
import cebartling.backbone.photogallery.domain.User
import cebartling.backbone.photogallery.domain.UserRole

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
        }


    }

    def destroy = {
    }

}
