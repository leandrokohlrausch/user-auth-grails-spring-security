package user.auth.sample

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	private static final long serialVersionUID = 1

	String authority

	static constraints = {
		authority nullable: false, blank: false, unique: true
	}

	static mapping = {
		cache true
		version false
		table "roles"
		id generator: "sequence", params: [sequence: "roles_id_seq"], sqlType : "serial"
		columns {
			id column: "id"
			authority column: "authority"
		}
	}
}
