package user.auth.sample

class BootStrap {

    def init = { servletContext ->
        User userAdmin = User.findByUsername("leandro")
        if (userAdmin == null) {

            Role adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true, failOnError: true)

            userAdmin = new User(username: 'leandro', password: 'leandro', email: "leandro@test.com", name: "Leandro").save(flush: true, failOnError: true)

            new UserRole(user: userAdmin, role: adminRole).save(flush: true, failOnError: true)

            new Requestmap(url: '/login/auth', configAttribute: 'permitAll').save(flush: true)
            new Requestmap(url: '/logout/**', configAttribute: 'permitAll').save(flush: true)
            new Requestmap(url: '/', configAttribute: 'IS_AUTHENTICATED_FULLY,IS_AUTHENTICATED_REMEMBERED').save(flush: true)
            new Requestmap(url: '/users/index', configAttribute: 'IS_AUTHENTICATED_FULLY,IS_AUTHENTICATED_REMEMBERED').save(flush: true)
            new Requestmap(url: '/users/list', configAttribute: adminRole.authority).save(flush: true)
            new Requestmap(url: '/users/show/**', configAttribute: 'IS_AUTHENTICATED_FULLY,IS_AUTHENTICATED_REMEMBERED').save(flush: true)
            new Requestmap(url: '/users/create', configAttribute: 'permitAll').save(flush: true)
            new Requestmap(url: '/users/save', configAttribute: 'permitAll').save(flush: true)
        }
    }
    def destroy = {
    }
}
