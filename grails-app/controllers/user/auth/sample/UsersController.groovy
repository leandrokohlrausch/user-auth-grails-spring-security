package user.auth.sample

class UsersController {

    UsersService usersService
    RolesService rolesService

    def index() {
        User user = getAuthenticatedUser()
        [user:  user ]
    }

    def list() {
        [users: usersService.findAllUser()]
    }

    def create() {
        [user: new User(), roles: rolesService.findAllRoles()]
    }

    def save() {
        User user = new User()
        bindData(user, params)
        if (params?.userRole instanceof String) params.userRole = [params.userRole]
        List roles = []
        for (String id : params.userRole) {
            roles << rolesService.findRoleById(id.toLong())
        }
        usersService.saveNewUser(user, roles)
        redirect(controller: 'login', action: 'auth')
    }

    def show() {
        Long id = params.id?.toLong()
        [user: usersService.findUserById(id), roles: rolesService.findAllRoles()]
    }
}
