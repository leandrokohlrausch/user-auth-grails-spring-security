package user.auth.sample

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService

@Transactional
class RolesService extends RolesRepository {

    RequestMapsService requestMapsService
    SpringSecurityService springSecurityService

    def serviceMethod() {

    }

    List<Role> findAllRoles() {
        return Role.findAll()
    }

    Role findRoleById(Long id) {
        return Role.findById(id)
    }

    void createNewRole(Role role) {
        role.save(flush: true)
    }

    /**
     * Sample Native query
     * @param id
     */
    void deleteRole(Long id) {
        Role role = this.findRoleById(id)
        List<Requestmap> requestmaps = requestMapsService.findAllByRole(role)
        StringBuilder str = new StringBuilder("BEGIN; ")
        List args = []
        requestmaps.each {
            String configAttribute = it.configAttribute.replace(role.authority, "").replace(",,", ",");
            str << "UPDATE request_maps SET config_attribute = ? WHERE id = ?; "
            args << configAttribute
            args << it.id
        }
        str << "DELETE FROM users_roles WHERE role_id = ?; "
        args << role.id
        str << "DELETE FROM roles WHERE id = ?; "
        args << role.id
        str << "COMMIT; END;"
        super.getJdbcTemplate().update(str.toString(), args.toArray())
        springSecurityService.clearCachedRequestmaps()
    }
}
