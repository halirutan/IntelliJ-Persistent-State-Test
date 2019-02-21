package de.halirutan.persistence

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import com.intellij.util.xmlb.annotations.XCollection

/**
 * Created by patrick on 21.02.19.
 * (c) Patrick Scheibe 2019
 */
@State(
    name = "ServerConfiguration",
    storages = [Storage(file = "myServerConfig.xml")]
)
class ServerConfigList : PersistentStateComponent<ServerConfigList> {

    @XCollection(elementTypes = [Server::class])
    val servers: MutableList<Server> = mutableListOf()

    override fun getState(): ServerConfigList? {
        return this
    }

    override fun loadState(state: ServerConfigList) {
        XmlSerializerUtil.copyBean(state, this)
    }

}