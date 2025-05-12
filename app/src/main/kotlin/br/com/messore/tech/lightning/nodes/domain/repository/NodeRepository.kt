package br.com.messore.tech.lightning.nodes.domain.repository

import br.com.messore.tech.lightning.nodes.domain.model.Node

interface NodeRepository {
    suspend fun getNodes(): List<Node>
}
