package br.com.messore.tech.lightning.nodes.factory

import br.com.messore.tech.lightning.nodes.data.remote.model.NodeRemote

internal object NodeRemoteFactory {

    internal fun list() = listOf(
        create1MLNode(),
        createWalletOfSatoshiNode(),
    )

    internal fun create1MLNode() = NodeRemote(
        publicKey = "0217890e3aad8d35bc054f43acc00084b25229ecff0ab68debd82883ad65ee8266",
        alias = "1ML.com node ALPHA",
        channels = 1723,
        capacity = 56882493178.0,
        firstSeen = 1529506821,
        updatedAt = 1746803196,
        city = mapOf(
            "de" to "New York City",
            "en" to "New York",
            "es" to "Nueva York",
            "fr" to "New York",
            "ja" to "ニューヨーク",
            "pt-BR" to "Nova Iorque",
            "ru" to "Нью-Йорк",
        ),
        country = mapOf(
            "de" to "Vereinigte Staaten",
            "en" to "United States",
            "es" to "Estados Unidos",
            "fr" to "États Unis",
            "ja" to "アメリカ",
            "pt-BR" to "EUA",
            "ru" to "США",
            "zh-CN" to "美国",
        ),
    )

    internal fun createWalletOfSatoshiNode() = NodeRemote(
        publicKey = "035e4ff418fc8b5554c5d9eea66396c227bd429a3251c8cbc711002ba215bfc226",
        alias = "WalletOfSatoshi.com",
        channels = 1383,
        capacity = 17533343981.0,
        firstSeen = 1601429940,
        updatedAt = 1746804306,
        city = null,
        country = mapOf(
            "de" to "Kanada",
            "en" to "Canada",
            "es" to "Canadá",
            "fr" to "Canada",
            "ja" to "カナダ",
            "pt-BR" to "Canadá",
            "ru" to "Канада",
            "zh-CN" to "加拿大",
        ),
    )

    internal fun createGameb_1() = NodeRemote(
        publicKey = "023d70f2f76d283c6c4e58109ee3a2816eb9d8feb40b23d62469060a2b2867b77f",
        alias = "gameb_1",
        channels = 656,
        capacity = 426225420.0,
        firstSeen = 1593656979L,
        updatedAt = 1746801740L,
        city = mapOf(
            "en" to "Ashburn",
            "ru" to "Ашберн",
        ),
        country = mapOf(
            "en" to "United States",
            "ru" to "США",
        ),
    )
}
