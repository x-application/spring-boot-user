package x.app.config

import org.axonframework.commandhandling.CommandBus
import org.axonframework.modelling.command.Repository
import org.springframework.context.annotation.Configuration
import x.app.service.user.User
import x.app.service.user.interceptor.UserInterceptor
import x.app.utils.extension.IExtensionExecutor

/**
 *   @Project: spring-boot-user
 *   @Package: x.app.config
 *   @Author:  Iamee
 *   @Date:    2019-05-03 14:37
 */
@Configuration
class AutoInterceptor(
        commandBus: CommandBus,
        repository: Repository<User>,
        executor: IExtensionExecutor

) {
    init {
        commandBus.registerHandlerInterceptor(UserInterceptor(repository = repository, executor = executor))
    }
}