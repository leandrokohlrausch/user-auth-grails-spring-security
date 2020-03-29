package user.auth.sample

import grails.gorm.transactions.Transactional

@Transactional
class RolesService {

    def serviceMethod() {

    }

    List<Role> getAllRoles() {
        return Role.findAll()
    }

    Role findRoleById(Long id) {
        return Role.findById(id)
    }
}
