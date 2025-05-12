package br.com.messore.tech.lightning.nodes.data.remote.service

import br.com.messore.tech.lightning.nodes.data.remote.model.NodeRemote

internal interface NodeService {
    suspend fun getNodes(): List<NodeRemote>
}
