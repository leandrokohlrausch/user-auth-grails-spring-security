package user.auth.sample

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService

@Transactional
class RequestMapsService {

    SpringSecurityService springSecurityService

    def serviceMethod() {

    }

    List<Requestmap> findAllRequestMaps() {
        return Requestmap.findAll()
    }

    List<Requestmap> findAllByRole(Role role){
        String like = "%${role.authority}%"
        List<Requestmap> requestmaps = Requestmap.findAllByConfigAttributeLike(like)
        return requestmaps
    }

    void deleteRequestMap(Long id) {
        Requestmap requestmap = Requestmap.findById(id)
        if (requestmap) requestmap.delete(flush: true)
        springSecurityService.clearCachedRequestmaps()
    }

    void saveRequestMap(Requestmap requestmap) {
        requestmap.save(flush: true)
        springSecurityService.clearCachedRequestmaps()
    }
}
