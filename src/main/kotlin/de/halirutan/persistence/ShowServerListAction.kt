package de.halirutan.persistence

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.messages.MessageDialog

/**
 * Created by patrick on 21.02.19.
 * (c) Patrick Scheibe 2019
 */
class ShowServerListAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val conf = ServiceManager.getService(ServerConfigList::class.java)
        val servers = conf.servers
        val serverInfo = servers.joinToString(separator = "\n") { s ->
            "Server: ${s.name}, Port: ${s.port}, Token: ${s.token}"
        }
        Messages.showInfoMessage(serverInfo, "List of servers")
    }
}
