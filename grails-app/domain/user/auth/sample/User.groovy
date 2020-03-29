package user.auth.sample

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false
    String name
    String email

    Set<Role> getAuthorities() {
        if (!this.id) return Collections.emptySet();

        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        email nullable: false, blank: false, unique: true
        name nullable: false, blank: false
    }

    static mapping = {
        cache true
        version false
        table "users"
        id generator: "sequence", params: [sequence: "users_id_seq"], sqlType : "serial"
        columns {
            id column: "id"
            username column: "username"
            password column: "password"
            enabled column: "enabled"
            accountExpired column: "account_expired"
            accountLocked column: "account_locked"
            passwordExpired column: "password_expired"
            email column : "email"
            name column : "name"
        }
    }
}
