package br.com.messore.tech.lightning.nodes.data.remote.api

import br.com.messore.tech.lightning.nodes.data.remote.util.HttpClientMock
import br.com.messore.tech.lightning.nodes.data.remote.util.loadJson
import br.com.messore.tech.lightning.nodes.data.remote.util.respondSuccess
import io.ktor.client.engine.mock.MockEngine
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class NodeApiTest {

    @Test
    fun `should return list of nodes on successful API call`() = runTest {
        val mockEngine = MockEngine { request ->
            assertEquals(
                expected = request.url.encodedPath,
                actual = "/api/v1/lightning/nodes/rankings/connectivity",
            )

            respondSuccess(loadJson("nodes.json").orEmpty())
        }

        NodeApi(HttpClientMock(mockEngine).httpClient).getNodes().also {
            assertNotNull(it)
            assertEquals(expected = it.size, actual = 5)
        }
    }

    @Test
    fun `should return empty list when API call is successful but no nodes are found`() = runTest {
        val mockEngine = MockEngine { request ->
            assertEquals(
                expected = request.url.encodedPath,
                actual = "/api/v1/lightning/nodes/rankings/connectivity",
            )

            respondSuccess("[]")
        }

        NodeApi(HttpClientMock(mockEngine).httpClient).getNodes().also {
            assertNotNull(it)
            assertEquals(expected = 0, actual = it.size)
        }
    }

    @Test
    fun `should propagate exception when API call fails`() = runTest {
        val mockEngine = MockEngine { throw RuntimeException("API call failed") }

        try {
            NodeApi(HttpClientMock(mockEngine).httpClient).getNodes()
        } catch (e: Exception) {
            assertEquals(expected = "API call failed", actual = e.message)
        }
    }

    @Test
    fun `should throw exception when API call returns invalid JSON body`() = runTest {
        val mockEngine = MockEngine { respondSuccess("invalid json") }

        try {
            NodeApi(HttpClientMock(mockEngine).httpClient).getNodes()
        } catch (e: Exception) {
            assertNotNull(e)
        }
    }
}
