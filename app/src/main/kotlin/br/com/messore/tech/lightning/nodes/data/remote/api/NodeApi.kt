package br.com.messore.tech.lightning.nodes.data.remote.api

import br.com.messore.tech.lightning.nodes.data.remote.model.NodeRemote
import br.com.messore.tech.lightning.nodes.data.remote.service.NodeService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path

internal class NodeApi(
    private val httpClient: HttpClient,
) : NodeService {
    override suspend fun getNodes(): List<NodeRemote> {
        return httpClient.get {
            url {
                path(NODE_RANKINGS)
            }
        }.body()
    }

    companion object {
        private const val NODE_RANKINGS = "/api/v1/lightning/nodes/rankings/connectivity"
    }
}
