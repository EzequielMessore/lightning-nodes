package br.com.messore.tech.lightning.nodes.data.data.repository

import br.com.messore.tech.lightning.nodes.data.remote.service.NodeService
import br.com.messore.tech.lightning.nodes.factory.NodeRemoteFactory.create1MLNode
import br.com.messore.tech.lightning.nodes.factory.NodeRemoteFactory.createWalletOfSatoshiNode
import br.com.messore.tech.lightning.nodes.factory.NodeRemoteFactory.list
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import java.util.Locale
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class NodeRepositoryImplTest {

    private val service = mockk<NodeService>()
    private val nodeRepository = NodeRepositoryImpl(service)

    @BeforeTest
    fun setUp() {
        Locale.setDefault(Locale.US)
    }

    @Test
    fun `should retrieve and map nodes successfully`() = runTest {
        coEvery { service.getNodes() } returns list()

        val result = nodeRepository.getNodes()

        assertEquals(expected = 2, actual = result.size)
        assertEquals(expected = "New York, United States", actual = result.first().location)
        assertEquals(expected = "Canada", actual = result.last().location)
    }

    @Test
    fun `should return empty list when service returns no nodes`() = runTest {
        coEvery { service.getNodes() } returns emptyList()

        val result = nodeRepository.getNodes()

        assertTrue(result.isEmpty())
    }

    @Test
    fun `should return null location when city and country are null`() = runTest {
        coEvery { service.getNodes() } returns listOf(
            create1MLNode().copy(city = null, country = null),
        )

        val result = nodeRepository.getNodes()

        assertNull(result.first().location)
    }

    @Test
    fun `should map location with only country when city is null`() = runTest {
        coEvery { service.getNodes() } returns listOf(
            createWalletOfSatoshiNode(),
        )

        val result = nodeRepository.getNodes()

        assertEquals("Canada", result.first().location)
    }

    @Test
    fun `should map location with only city when country is null`() = runTest {
        coEvery { service.getNodes() } returns listOf(
            create1MLNode().copy(country = null),
        )

        val result = nodeRepository.getNodes()

        assertEquals("New York", result.first().location)
    }

    @Test
    fun `should return null location when no mapping exists for device language`() = runTest {
        coEvery { service.getNodes() } returns listOf(
            create1MLNode().copy(
                city = mapOf("fr-FR" to "Paris"),
                country = mapOf("fr-FR" to "France"),
            ),
        )

        val result = nodeRepository.getNodes()

        assertNull(result.first().location)
    }

    @Test
    fun `should map location with city and country for device language`() = runTest {
        coEvery { service.getNodes() } returns listOf(create1MLNode())

        val result = nodeRepository.getNodes()

        assertEquals("New York, United States", result.first().location)
    }
}
