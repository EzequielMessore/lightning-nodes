package br.com.messore.tech.lightning.nodes.factory

import br.com.messore.tech.lightning.nodes.domain.model.Node

internal object NodeFactory {

    internal fun list() = listOf(
        create1MLNode(),
        createGameb_1(),
        createWalletOfSatoshiNode(),
    )

    internal fun create1MLNode() = Node(
        publicKey = "0217890e3aad8d35bc054f43acc00084b25229ecff0ab68debd82883ad65ee8266",
        alias = "1ML.com node ALPHA",
        channels = 1723,
        capacity = "767.51",
        firstSeen = "Jun 20, 2018, 3:00:21 PM",
        updatedAt = "May 9, 2025, 3:06:36 PM",
        location = "New York, United States",
    )

    internal fun createWalletOfSatoshiNode() = Node(
        publicKey = "035e4ff418fc8b5554c5d9eea66396c227bd429a3251c8cbc711002ba215bfc226",
        alias = "WalletOfSatoshi.com",
        channels = 1383,
        capacity = "17533.34",
        firstSeen = "Sep 30, 2020, 1:39:00 AM",
        updatedAt = "May 9, 2025, 3:25:06 PM",
        location = "Canada",
    )

    internal fun createGameb_1() = Node(
        alias = "gameb_1",
        channels = 656,
        capacity = "4.26",
        publicKey = "023d70f2f76d283c6c4e58109ee3a2816eb9d8feb40b23d62469060a2b2867b77f",
        location = "Ashburn, United States",
        firstSeen = "Jul 2, 2020, 2:29:39 AM",
        updatedAt = "May 9, 2025, 2:42:20 PM",
    )
}
