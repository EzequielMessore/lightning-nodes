package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.view.model

import app.cash.turbine.test
import br.com.messore.tech.lightning.nodes.domain.repository.NodeRepository
import br.com.messore.tech.lightning.nodes.factory.NodeFactory
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.BottomSheet
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewIntent
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewState
import br.com.messore.tech.lightning.nodes.presentation.view.model.TestCoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class NodesViewModelTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val repository = mockk<NodeRepository>()

    private lateinit var viewModel: NodesViewModel
    private lateinit var initialState: NodesViewState

    @BeforeTest
    fun setUp() {
        initialState = NodesViewState()

        viewModel = NodesViewModel(
            repository = repository,
            dispatchersProvider = testCoroutineRule.providers,
        )
    }

    @Test
    fun `should update view state to loading and success when GetNodes`() = runTest {
        coEvery { repository.getNodes() } returns NodeFactory.list()

        viewModel.onIntent(NodesViewIntent.GetNodes)

        viewModel.viewState.test {
            assertEquals(initialState.loading(), awaitItem())
            assertEquals(initialState.success(NodeFactory.list()), awaitItem())
        }
    }

    @Test
    fun `should re-fetch nodes when Retry`() = runTest {
        coEvery { repository.getNodes() } returns NodeFactory.list()

        viewModel.onIntent(NodesViewIntent.Retry)

        viewModel.viewState.test {
            assertEquals(initialState.loading(), awaitItem())
            assertEquals(initialState.success(NodeFactory.list()), awaitItem())
        }
    }

    @Test
    fun `should sort nodes by alias when OrderChange intent with Alias order`() = runTest {
        val nodes = NodeFactory.list()
        coEvery { repository.getNodes() } returns nodes

        viewModel.onIntent(NodesViewIntent.GetNodes)
        viewModel.viewState.test {
            skipItems(2)
        }

        viewModel.onIntent(NodesViewIntent.OrderChange(NodesViewIntent.OrderChange.Order.ALIAS))
        viewModel.viewState.test {
            val sortedNodes = nodes.sortedBy { it.alias }
            assertEquals(initialState.success(sortedNodes), awaitItem())
        }
    }

    @Test
    fun `should sort nodes by number of channels when OrderChange intent with Channels order`() = runTest {
        val nodes = NodeFactory.list()
        coEvery { repository.getNodes() } returns nodes

        viewModel.onIntent(NodesViewIntent.GetNodes)
        viewModel.viewState.test {
            skipItems(2)
        }

        viewModel.onIntent(NodesViewIntent.OrderChange(NodesViewIntent.OrderChange.Order.CHANNELS))
        viewModel.viewState.test {
            val sortedNodes = nodes.sortedBy { it.channels }
            assertEquals(initialState.copy(order = NodesViewIntent.OrderChange.Order.CHANNELS).success(sortedNodes), awaitItem())
        }
    }

    @Test
    fun `should sort nodes by capacity when OrderChange intent with Capacity order`() = runTest {
        val nodes = NodeFactory.list()
        coEvery { repository.getNodes() } returns nodes

        viewModel.onIntent(NodesViewIntent.GetNodes)
        viewModel.viewState.test {
            skipItems(2)
        }

        viewModel.onIntent(NodesViewIntent.OrderChange(NodesViewIntent.OrderChange.Order.CAPACITY))
        viewModel.viewState.test {
            val sortedNodes = nodes.sortedBy { it.capacity.toBigDecimalOrNull() }
            assertEquals(initialState.copy(order = NodesViewIntent.OrderChange.Order.CAPACITY).success(sortedNodes), awaitItem())
        }
    }

    @Test
    fun `should handle gracefully when OrderChange intent with no existing nodes`() = runTest {
        viewModel.onIntent(NodesViewIntent.OrderChange(NodesViewIntent.OrderChange.Order.ALIAS))

        viewModel.viewState.test {
            assertEquals(initialState, awaitItem())
        }
    }

    @Test
    fun `should update bottomSheet property in view state when BottomSheet intent`() = runTest {
        viewModel.onIntent(NodesViewIntent.ShowBottomSheet)

        viewModel.viewState.test {
            assertEquals(initialState.copy(bottomSheet = BottomSheet(true)), awaitItem())
        }

        viewModel.onIntent(NodesViewIntent.HideBottomSheet)

        viewModel.viewState.test {
            assertEquals(initialState.copy(bottomSheet = BottomSheet(false)), awaitItem())
        }
    }
}
