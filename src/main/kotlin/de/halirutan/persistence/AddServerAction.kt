package de.halirutan.persistence

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.ui.InputValidator
import com.intellij.openapi.ui.Messages

/**
 * Created by patrick on 21.02.19.
 * (c) Patrick Scheibe 2019
 */
class AddServerAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val conf = ServiceManager.getService(ServerConfigList::class.java)
        val dialog = { msg: String ->
            Messages.InputDialog(
                msg,
                "Server",
                null,
                null,
                Validator()
            )
        }

        val newServer = dialog("Input server name")
        val newPort = dialog("Input port")
        val newToken = dialog("Input token")

        newServer.show()
        newPort.show()
        newToken.show()

        conf.servers.add(
            Server(
                newServer.inputString ?: "CrappyServer",
                newPort.inputString ?: "0815",
                newToken.inputString ?: "HolyToken")
        )
    }


    class Validator : InputValidator {
        override fun checkInput(inputString: String?): Boolean {
            if (inputString != null && inputString.isNotEmpty()) {
                return true
            }
            return false
        }

        override fun canClose(inputString: String?): Boolean {
            return checkInput(inputString)
        }

    }
}
