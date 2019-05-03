package x.app.mock

import org.axonframework.commandhandling.CommandHandler
import org.springframework.stereotype.Component
import x.app.common.AbstractResult
import x.app.common.account.command.CreateAccountBondCommand
import x.app.common.account.command.CreateAccountCommand

/**
 *   @Project: spring-boot-user
 *   @Package: x.app.mock
 *   @Author:  Iamee
 *   @Date:    2019-05-03 14:42
 */
@Component
class AccountCommandHandler {

    @CommandHandler
    fun handle(command: CreateAccountCommand): AbstractResult {
        return CreateAccountCommand.Result(accountId = command.accountId)
    }

    @CommandHandler
    fun handle(command: CreateAccountBondCommand): AbstractResult {
        return CreateAccountBondCommand.Result(accountId = command.accountId, userId = command.userId)
    }

}