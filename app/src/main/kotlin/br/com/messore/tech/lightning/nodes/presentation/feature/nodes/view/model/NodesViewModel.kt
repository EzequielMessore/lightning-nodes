package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.view.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.messore.tech.lightning.nodes.core.DispatchersProvider
import br.com.messore.tech.lightning.nodes.core.execute
import br.com.messore.tech.lightning.nodes.domain.repository.NodeRepository
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.BottomSheet
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewIntent
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewIntent.OrderChange.Order
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NodesViewModel(
    private val repository: NodeRepository,
    private val dispatchersProvider: DispatchersProvider,
) : ViewModel() {
    private val _viewState = MutableStateFlow(NodesViewState())
    val viewState = _viewState.asStateFlow()

    fun onIntent(intent: NodesViewIntent) {
        when (intent) {
            NodesViewIntent.GetNodes -> getNodes()
            NodesViewIntent.Retry -> getNodes()
            is NodesViewIntent.OrderChange -> orderNodes(intent.order)
            is NodesViewIntent.ShowBottomSheet -> updateBottomSheet(true)
            is NodesViewIntent.HideBottomSheet -> updateBottomSheet(false)
        }
    }

    private fun getNodes() = viewModelScope.launch {
        _viewState.update { it.loading() }
        execute(
            dispatcher = dispatchersProvider.io,
            execute = repository::getNodes,
            onSuccess = { nodes ->
                _viewState.update { it.success(nodes) }
            },
            onFailure = {
                _viewState.update { it.error() }
            },
        )
    }

    private fun orderNodes(order: Order) {
        val nodes = _viewState.value.nodes
        val orderedNodes = when (order) {
            Order.ALIAS -> nodes.sortedBy { it.alias }
            Order.CHANNELS -> nodes.sortedBy { it.channels }
            Order.CAPACITY -> nodes.sortedBy { it.capacity.toBigDecimalOrNull() }
        }

        _viewState.update { it.copy(nodes = orderedNodes, order = order) }
    }

    private fun updateBottomSheet(isShowing: Boolean) {
        _viewState.update { it.copy(bottomSheet = BottomSheet(isShowing)) }
    }
}
