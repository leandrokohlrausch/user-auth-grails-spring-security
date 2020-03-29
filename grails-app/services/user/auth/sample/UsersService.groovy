package user.auth.sample

import grails.gorm.transactions.Transactional

@Transactional
class UsersService {

    def serviceMethod() {

    }

    List<User> getAllUser() {
        return User.findAll()
    }

    User getUserById(Long id) {
        return User.findById(id)
    }

    void saveNewUser(User user, List<Role> roles) {
        user.save()
        roles.each {
            new UserRole(user: user, role: it).save()
        }
    }

}
