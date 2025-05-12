package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.preview

import br.com.messore.tech.lightning.nodes.domain.model.Node
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewState
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.ScreenType

object PreviewFactory {
    fun nodeViewState() = NodesViewState(
        nodes = nodes(),
        screenType = ScreenType.SUCCESS,
    )

    private fun nodes() = listOf(
        Node(
            publicKey = "03864ef025fde8fb587d989186ce6a4a186895ee44a926bfc370e2c366597a3f8f",
            alias = "ACINQ",
            channels = 2325,
            capacity = "568.82",
            firstSeen = "Apr 5, 2018, 3:13:42 PM",
            updatedAt = "May 9, 2025, 3:26:56 PM",
            location = "United States",
        ),
        Node(
            publicKey = "0217890e3aad8d35bc054f43acc00084b25229ecff0ab68debd82883ad65ee8266",
            alias = "1ML.com node ALPHA",
            channels = 1723,
            capacity = "767.51",
            firstSeen = "Jun 20, 2018, 3:00:21 PM",
            updatedAt = "May 9, 2025, 3:06:36 PM",
            location = "New York, United States",
        ),
        Node(
            publicKey = "035e4ff418fc8b5554c5d9eea66396c227bd429a3251c8cbc711002ba215bfc226",
            alias = "WalletOfSatoshi.com",
            channels = 1383,
            capacity = "17533.34",
            firstSeen = "Sep 30, 2020, 1:39:00 AM",
            updatedAt = "May 9, 2025, 3:25:06 PM",
            location = "Canada",
        ),
        Node(
            publicKey = "02f1a8c87607f415c8f22c00593002775941dea48869ce23096af27b0cfdcc0b69",
            alias = "Kraken 🐙⚡",
            channels = 1132,
            capacity = "261.60",
            firstSeen = "Apr 13, 2022, 3:12:38 PM",
            updatedAt = "May 9, 2025, 3:26:56 PM",
            location = "Gurugram, India",
        ),
    )
}
