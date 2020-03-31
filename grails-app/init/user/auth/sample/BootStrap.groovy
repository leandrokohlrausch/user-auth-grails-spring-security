package user.auth.sample

class BootStrap {

    def init = { servletContext ->
        User userAdmin = User.findByUsername("administrator")
        if (userAdmin == null) {
            String roleAdmin = 'ROLE_ADMIN'
            Role adminRole = new Role(authority: roleAdmin).save(flush: true, failOnError: true)
            userAdmin = new User(username: 'administrator', password: 'administrator', email: "administrator@yourcompany.com", name: "Administrator").save(flush: true, failOnError: true)
            new UserRole(user: userAdmin, role: adminRole).save(flush: true, failOnError: true)
            new Requestmap(url: '/login/auth', configAttribute: 'permitAll').save(flush: true)
            new Requestmap(url: '/logout/**', configAttribute: 'permitAll').save(flush: true)
            new Requestmap(url: '/', configAttribute: 'IS_AUTHENTICATED_FULLY,IS_AUTHENTICATED_REMEMBERED').save(flush: true)
            new Requestmap(url: '/users/index', configAttribute: 'IS_AUTHENTICATED_FULLY,IS_AUTHENTICATED_REMEMBERED').save(flush: true)
            new Requestmap(url: '/users/list', configAttribute: roleAdmin).save(flush: true)
            new Requestmap(url: '/users/show/**', configAttribute: 'IS_AUTHENTICATED_FULLY,IS_AUTHENTICATED_REMEMBERED').save(flush: true)
            new Requestmap(url: '/users/create', configAttribute: 'permitAll').save(flush: true)
            new Requestmap(url: '/users/save', configAttribute: 'permitAll').save(flush: true)
            new Requestmap(url: '/roles/index', configAttribute: roleAdmin).save(flush: true)
            new Requestmap(url: '/roles/create', configAttribute: roleAdmin).save(flush: true)
            new Requestmap(url: '/roles/save', configAttribute: roleAdmin).save(flush: true)
            new Requestmap(url: '/roles/delete/**', configAttribute: roleAdmin).save(flush: true)
            new Requestmap(url: '/requestMaps/index', configAttribute: roleAdmin).save(flush: true)
            new Requestmap(url: '/requestMaps/create', configAttribute: roleAdmin).save(flush: true)
            new Requestmap(url: '/requestMaps/save', configAttribute: roleAdmin).save(flush: true)
            new Requestmap(url: '/requestMaps/delete/**', configAttribute: roleAdmin).save(flush: true)
        }
    }
    def destroy = {
    }
}
