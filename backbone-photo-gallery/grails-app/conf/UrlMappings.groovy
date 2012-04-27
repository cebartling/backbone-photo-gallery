class UrlMappings {

    static mappings = {

        "/profiles"(controller: 'profile', action: 'index', parseRequest: false)

        "/profiles/$id"(controller: "profile", parseRequest: true) {
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
    }
}
