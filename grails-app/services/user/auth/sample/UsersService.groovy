package user.auth.sample

import grails.gorm.transactions.Transactional

@Transactional
class UsersService {

    def serviceMethod() {

    }

    List<User> findAllUser() {
        return User.findAll()
    }

    User findUserById(Long id) {
        return User.findById(id)
    }

    void saveNewUser(User user, List<Role> roles) {
        user.save()
        roles.each {
            new UserRole(user: user, role: it).save()
        }
    }

}
