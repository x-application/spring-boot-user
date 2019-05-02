package x.app

import org.axonframework.common.IdentifierFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import x.app.common.CommonService
import x.app.utils.extension.annotation.EnableExtension
import x.app.utils.safecommand.annotation.EnableSafeCommand

@EnableExtension
@EnableSafeCommand
@SpringBootApplication
class SpringBootUserApplication {

    @Bean
    fun service(): CommonService {
        return object : CommonService {
            override fun currentTimeMillis(): Long {
                return System.currentTimeMillis()
            }

            override fun generateIdentifier(): String {
                return IdentifierFactory.getInstance().generateIdentifier()
            }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<SpringBootUserApplication>(*args)
}
