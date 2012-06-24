modules = {

    core {
        dependsOn 'jquery, bootstrap'
        resource url: '/js/vendor/underscore.js'
        resource url: '/js/vendor/backbone.js'
        resource url: '/js/vendor/json2.js'
        resource url: '/js/vendor/handlebars-1.0.0.beta.6.js'
        resource url: 'css/extras.css'
    }

    applicationBackbone {
        resource url: '/js/application/backbone/models.js'
        resource url: '/js/application/backbone/views.js'
    }

    profile {
        dependsOn 'core'
        dependsOn 'applicationBackbone'
        resource url: '/js/application/profile/index.js'
    }

}
