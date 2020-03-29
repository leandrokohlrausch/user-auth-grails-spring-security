package user.auth.sample

class UsersController {

    UsersService usersService
    RolesService rolesService

    def index() {
        User user = getAuthenticatedUser()
        [user:  user ]
    }

    def list() {
        [users: usersService.getAllUser()]
    }

    def create() {
        [user: new User(), roles: rolesService.getAllRoles()]
    }

    def save() {
        try {
            User user = new User()
            bindData(user, params)
            if (params?.userRole instanceof String) params.userRole = [params.userRole]
            List roles = []
            for (String id : params.userRole) {
                roles << rolesService.findRoleById(id.toLong())
            }
            usersService.saveNewUser(user, roles)
            redirect(controller: 'login', action: 'auth')
        } catch (Exception e) {
            flash.error = e.message
        }
    }

    def show() {
        Long id = params.id?.toLong()
        [user: usersService.getUserById(id), roles: rolesService.getAllRoles()]
    }
}
