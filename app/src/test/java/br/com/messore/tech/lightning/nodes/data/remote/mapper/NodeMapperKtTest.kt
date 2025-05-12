package br.com.messore.tech.lightning.nodes.data.remote.mapper

import br.com.messore.tech.lightning.nodes.extensions.normalize
import br.com.messore.tech.lightning.nodes.factory.NodeRemoteFactory
import java.util.Locale
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class NodeMapperKtTest {
    @BeforeTest
    fun setUp() {
        Locale.setDefault(Locale.US)
    }

    @Test
    fun `should map NodeRemote to Node with all fields correctly`() {
        val nodeRemote = NodeRemoteFactory.create1MLNode()

        val result = nodeRemote.toNode()

        assertEquals(expected = "1ML.com node ALPHA", actual = result.alias)
        assertEquals(expected = "New York, United States", actual = result.location)
        assertEquals(
            expected = "0217890e3aad8d35bc054f43acc00084b25229ecff0ab68debd82883ad65ee8266",
            actual = result.publicKey,
        )
        assertEquals(expected = 1723, actual = result.channels)
        assertEquals(expected = "568.82493178", actual = result.capacity)
        assertEquals(expected = "Jun 20, 2018, 3:00:21 PM", actual = result.firstSeen.normalize())
        assertEquals(expected = "May 9, 2025, 3:06:36 PM", actual = result.updatedAt.normalize())
    }

    @Test
    fun `should map NodeRemote to Node with null location when city and country are null`() {
        val nodeRemote = NodeRemoteFactory.create1MLNode().copy(
            city = null,
            country = null,
        )
        val result = nodeRemote.toNode()

        assertNull(actual = result.location)
    }

    @Test
    fun `should use default language en when deviceLanguage is null`() {
        Locale.setDefault(Locale(""))

        val nodeRemote = NodeRemoteFactory.create1MLNode().copy(
            city = mapOf("en" to "Ashburn"),
            country = mapOf("en" to "United States"),
        )

        val result = nodeRemote.toNode()

        assertEquals(expected = "Ashburn, United States", actual = result.location)
    }

    @Test
    fun `should map NodeRemote to Node with fallback to en for complex location`() {
        val nodeRemote = NodeRemoteFactory.createGameb_1()

        val result = nodeRemote.toNode()
        Locale.setDefault(Locale.CANADA)

        assertEquals(expected = "Ashburn, United States", actual = result.location)
    }

    @Test
    fun `should convert capacity from sats to Bitcoin`() {
        val nodeRemote = NodeRemoteFactory.create1MLNode().copy(capacity = 550_000.0)

        val result = nodeRemote.toNode()

        assertEquals(expected = "0.0055", actual = result.capacity)
    }

    @Test
    fun `should map location with both city and country`() {
        val nodeRemote = NodeRemoteFactory.create1MLNode()

        val result = nodeRemote.toNode()

        assertEquals(expected = "New York, United States", actual = result.location)
    }

    @Test
    fun `should map location with only city when country is null`() {
        val nodeRemote = NodeRemoteFactory.create1MLNode().copy(country = null)

        val result = nodeRemote.toNode()

        assertEquals(expected = "New York", actual = result.location)
    }

    @Test
    fun `should map location with only country when city is null`() {
        val nodeRemote = NodeRemoteFactory.create1MLNode().copy(city = null)

        val result = nodeRemote.toNode()

        assertEquals(expected = "United States", actual = result.location)
    }

    @Test
    fun `should return null location when no mapping exists for device language`() {
        val nodeRemote = NodeRemoteFactory.create1MLNode().copy(
            city = mapOf("fr-FR" to "Paris"),
            country = mapOf("fr-FR" to "France"),
        )

        val result = nodeRemote.toNode()

        assertNull(result.location)
    }
}
