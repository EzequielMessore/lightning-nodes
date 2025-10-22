package br.com.messore.tech.lightning.nodes.presentation.feature.nodes

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.ErrorScreen
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.LoadingScreen
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.NodesScreen
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.components.OrderBottomSheet
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewIntent
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.ScreenType
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.view.model.NodesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun NodesRoute(
    viewModel: NodesViewModel = koinViewModel(),
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onIntent(NodesViewIntent.GetNodes)
    }

    when (state.screenType) {
        ScreenType.LOADING -> LoadingScreen()
        ScreenType.SUCCESS -> NodesScreen(
            state = state,
            onIntent = viewModel::onIntent,
        )

        ScreenType.ERROR -> ErrorScreen(
            onRetry = {
                viewModel.onIntent(NodesViewIntent.Retry)
            },
        )
    }

    if (state.bottomSheet.isShowing) {
        OrderBottomSheet(onDismiss = {
            viewModel.onIntent(NodesViewIntent.HideBottomSheet)
        }, onSelected = {
            viewModel.onIntent(NodesViewIntent.OrderChange(it))
        })
    }
}
