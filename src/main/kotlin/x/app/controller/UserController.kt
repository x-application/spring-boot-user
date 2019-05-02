package x.app.controller

import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import x.app.common.CommonService
import x.app.common.dsl.sendTo
import x.app.common.user.command.CreateUserCommand
import x.app.controller.req.CreateUserReq
import java.net.URI

/**
 *   @Project: spring-boot-user
 *   @Package: x.app.controller
 *   @Author:  Iamee
 *   @Date:    2019-05-02 23:11
 */
@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    lateinit var commandGateway: CommandGateway

    @Autowired
    lateinit var commonService: CommonService

    @PostMapping("/")
    fun create(@RequestBody body: CreateUserReq): ResponseEntity<Any> {
        val userId = commonService.generateIdentifier()
        (CreateUserCommand(userId = userId, password = body.password) sendTo commandGateway).run {
            this.exception?.run { throw this }
            return ResponseEntity.created(URI("user/${this.userId}")).build()
        }
    }

}