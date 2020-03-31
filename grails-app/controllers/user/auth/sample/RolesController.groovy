package user.auth.sample

class RolesController {

    RolesService rolesService

    def index() {
        [roles : rolesService.findAllRoles()]
    }

    def create() {
        [role: new Role()]
    }

    def save() {
        Role role = new Role()
        bindData(role, params)
        rolesService.createNewRole(role)
        redirect(controller: 'roles', action: 'index')
    }

    def delete() {
        Long id = params.id?.toLong()
        rolesService.deleteRole(id)
        redirect(controller: 'roles', action: 'index')
    }
}
