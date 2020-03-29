package user.auth.sample

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'users', action: 'index')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
