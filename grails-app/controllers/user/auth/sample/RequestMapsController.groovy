package user.auth.sample

import org.springframework.web.bind.annotation.RequestMethod

class RequestMapsController {

    RequestMapsService requestMapsService
    RolesService rolesService

    def index() {
        [requestMaps : requestMapsService.findAllRequestMaps()]
    }

    def create() {
        List roles = rolesService.findAllRoles().collect { it.authority }
        roles << "permitAll"
        roles << "IS_AUTHENTICATED_FULLY"
        roles << "IS_AUTHENTICATED_REMEMBERED"
        [requestMap: new Requestmap(), roles: roles, methods: RequestMethod.values()]
    }

    def save() {
        Requestmap requestmap = new Requestmap()
        bindData(requestmap, params, [exclude: ['configAttribute']])
        if (params?.configAttribute instanceof String) params.configAttribute = [params.configAttribute]
        requestmap.configAttribute = params.configAttribute.join(',')
        requestMapsService.saveRequestMap(requestmap)
        redirect(controller: 'requestMaps', action: 'index')
    }

    def delete() {
        Long id = params.id?.toLong()
        requestMapsService.deleteRequestMap(id)
        redirect(controller: 'requestMaps', action: 'index')
    }
}
