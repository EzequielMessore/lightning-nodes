package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state

interface NodesViewIntent {
    data object GetNodes : NodesViewIntent
    data object Retry : NodesViewIntent

    data class OrderChange(val order: Order) : NodesViewIntent {
        enum class Order {
            ALIAS, CHANNELS, CAPACITY,
        }
    }

    data object ShowBottomSheet : NodesViewIntent
    data object HideBottomSheet : NodesViewIntent
}
