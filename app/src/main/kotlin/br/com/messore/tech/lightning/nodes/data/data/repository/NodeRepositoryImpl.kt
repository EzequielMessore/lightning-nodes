package br.com.messore.tech.lightning.nodes.data.data.repository

import br.com.messore.tech.lightning.nodes.data.remote.mapper.toNode
import br.com.messore.tech.lightning.nodes.data.remote.model.NodeRemote
import br.com.messore.tech.lightning.nodes.data.remote.service.NodeService
import br.com.messore.tech.lightning.nodes.domain.model.Node
import br.com.messore.tech.lightning.nodes.domain.repository.NodeRepository

internal class NodeRepositoryImpl(
    private val service: NodeService,
) : NodeRepository {
    override suspend fun getNodes(): List<Node> {
        return service.getNodes()
            .map(NodeRemote::toNode)
    }
}
