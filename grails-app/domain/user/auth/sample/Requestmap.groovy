package user.auth.sample

import org.springframework.http.HttpMethod

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes=['configAttribute', 'httpMethod', 'url'])
@ToString(includes=['configAttribute', 'httpMethod', 'url'], cache=true, includeNames=true, includePackage=false)
class Requestmap implements Serializable {

	private static final long serialVersionUID = 1

	String configAttribute
	HttpMethod httpMethod
	String url

	static constraints = {
		configAttribute nullable: false, blank: false
		httpMethod nullable: true
		url nullable: false, blank: false, unique: 'httpMethod'
	}

	static mapping = {
		cache true
		version false
		table "request_maps"
		id generator: "sequence", params: [sequence: "request_maps_id_seq"], sqlType : "serial"
		columns {
			id column: "id"
			configAttribute column: "config_attribute"
			httpMethod column: "http_method"
			url column: "url"
		}
	}
}
