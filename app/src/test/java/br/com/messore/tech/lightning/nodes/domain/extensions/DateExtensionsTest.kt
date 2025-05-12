package br.com.messore.tech.lightning.nodes.domain.extensions

import br.com.messore.tech.lightning.nodes.extensions.normalize
import java.time.DateTimeException
import java.time.LocalDateTime
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DateExtensionsTest {

    private val locale = Locale("pt", "BR")

    @Test
    fun `should convert timestamp in seconds to LocalDateTime`() {
        val timestamp = 1522941222L // 5 de abril de 2018, 15:13:42 GMT
        val expectedDateTime = LocalDateTime.of(2018, 4, 5, 15, 13, 42)

        val result = timestamp.toLocalDateTime()

        assertEquals(expected = expectedDateTime, actual = result)
    }

    @Test
    fun `should format LocalDateTime in MEDIUM format with specific locale`() {
        val dateTime = LocalDateTime.of(2018, 4, 5, 15, 13, 42)
        Locale.setDefault(locale)
        val result = dateTime.format()

        assertEquals(expected = "5 de abr. de 2018 15:13:42", actual = result)
    }

    @Test
    fun `should format LocalDateTime in MEDIUM format with US locale`() {
        val dateTime = LocalDateTime.of(2018, 4, 5, 15, 13, 42)
        Locale.setDefault(Locale.US)
        val result = dateTime.format()

        assertEquals(expected = "Apr 5, 2018, 3:13:42 PM", actual = result.normalize())
    }

    @Test
    fun `should format LocalDateTime in MEDIUM format with FR locale`() {
        val dateTime = LocalDateTime.of(2018, 4, 5, 15, 13, 42)
        Locale.setDefault(Locale.FRANCE)
        val result = dateTime.format()

        assertEquals(expected = "5 avr. 2018, 15:13:42", actual = result)
    }

    @Test
    fun `should handle zero timestamp correctly`() {
        val timestamp = 0L // 1 de janeiro de 1970, 00:00:00 GMT
        val expectedDateTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0)

        val result = timestamp.toLocalDateTime()

        assertEquals(expected = expectedDateTime, actual = result)
    }

    @Test
    fun `should handle extremely large timestamp`() {
        val timestamp = Long.MAX_VALUE

        assertFailsWith<DateTimeException> {
            timestamp.toLocalDateTime()
        }
    }

    @Test
    fun `should handle extremely small timestamp`() {
        val timestamp = Long.MIN_VALUE

        assertFailsWith<DateTimeException> {
            timestamp.toLocalDateTime()
        }
    }

    @Test
    fun `should not be affected by locale change during execution`() {
        val dateTime = LocalDateTime.of(2018, 4, 5, 15, 13, 42)
        Locale.setDefault(Locale.US)
        val resultBeforeChange = dateTime.format()

        Locale.setDefault(Locale.FRANCE)
        val resultAfterChange = dateTime.format()

        assertEquals("Apr 5, 2018, 3:13:42 PM", resultBeforeChange.normalize())
        assertEquals("5 avr. 2018, 15:13:42", resultAfterChange)
    }
}
