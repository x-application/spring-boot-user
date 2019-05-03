package x.app.config

import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.modelling.command.Repository
import org.axonframework.serialization.Serializer
import org.axonframework.serialization.json.JacksonSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import x.app.service.user.User
import x.app.utils.extension.IExtensionExecutor
import kotlin.reflect.KClass

/**
 *   @Project: spring-boot-user
 *   @Package: x.app.config
 *   @Author:  Iamee
 *   @Date:    2019-05-02 23:10
 */
@Configuration
class AxonConfig {

    @Bean
    @Primary
    fun serializer(): Serializer {
        return JacksonSerializer.builder().build()
    }

    @Bean
    fun userRepository(eventStore: EventStore): Repository<User> {
        return EventSourcingRepository.builder(User::class.java).eventStore(eventStore).build()
    }

    @Bean
    fun commandBus(): CommandBus {
        return SimpleCommandBus.builder().build()
    }

}