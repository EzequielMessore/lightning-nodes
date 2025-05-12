package br.com.messore.tech.lightning.nodes.domain.extensions

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

private val locale: Locale
    get() = Locale.getDefault()

fun Long.toLocalDateTime(): LocalDateTime {
    val instant = Instant.ofEpochSecond(this)
    return LocalDateTime.ofInstant(instant, ZoneId.of("GMT"))
}

fun LocalDateTime.format(): String {
    val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        .withLocale(locale)
        .withZone(ZoneId.of("GMT"))
    return this.format(formatter)
}
