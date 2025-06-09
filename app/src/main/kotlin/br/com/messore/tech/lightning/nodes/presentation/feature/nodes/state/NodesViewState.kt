package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state

import br.com.messore.tech.lightning.nodes.domain.model.Node
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewIntent.OrderChange.Order
import java.time.LocalDateTime

data class NodesViewState(
    val order: Order = Order.ALIAS,
    val nodes: List<Node> = emptyList(),
    val screenType: ScreenType = ScreenType.LOADING,
    val bottomSheet: BottomSheet = BottomSheet(false),
) {
    fun success(nodes: List<Node>) = copy(nodes = nodes, screenType = ScreenType.SUCCESS)

    fun error() = copy(screenType = ScreenType.ERROR)

    fun loading() = copy(screenType = ScreenType.LOADING)
}

data class BottomSheet(
    val isShowing: Boolean,
)