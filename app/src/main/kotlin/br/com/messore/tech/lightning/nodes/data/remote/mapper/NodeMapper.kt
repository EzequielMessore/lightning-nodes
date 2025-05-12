package br.com.messore.tech.lightning.nodes.data.remote.mapper

import br.com.messore.tech.lightning.nodes.data.remote.model.NodeRemote
import br.com.messore.tech.lightning.nodes.domain.extensions.format
import br.com.messore.tech.lightning.nodes.domain.extensions.toLocalDateTime
import br.com.messore.tech.lightning.nodes.domain.model.Node
import java.util.Locale

private const val BITCOIN = 100_000_000.0

internal fun NodeRemote.toNode(): Node {
    val deviceLanguage = Locale.getDefault().toLanguageTag().takeIf { it == "pt-BR" }
        ?: Locale.getDefault().language

    val city = this.city?.get(deviceLanguage) ?: this.city?.get("en")
    val country = this.country?.get(deviceLanguage) ?: this.country?.get("en")

    val location = listOfNotNull(city, country)
        .joinToString(", ")
        .ifEmpty { null }

    val capacityInBitcoin = (this.capacity / BITCOIN)

    return Node(
        alias = alias,
        location = location,
        channels = channels,
        publicKey = publicKey,
        capacity = capacityInBitcoin.toString(),
        firstSeen = firstSeen.toLocalDateTime().format(),
        updatedAt = updatedAt.toLocalDateTime().format(),
    )
}
