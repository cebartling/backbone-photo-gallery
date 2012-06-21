class UrlMappings {

    static mappings = {

        "/profiles/$profileId/albums"(controller: "album", action: 'list', parseRequest: true)
        "/albums/$albumId/photos"(controller: "photo", action: 'list', parseRequest: true)


        "/albums/$albumId/photos/$photoId"(controller: "photo", parseRequest: true) {
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/profiles/$profileId/albums/$albumId"(controller: "album", parseRequest: true) {
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }

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
