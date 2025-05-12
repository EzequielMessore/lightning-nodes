package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.preview.PreviewFactory
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.components.NodeItem
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.components.OrderNode
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewIntent
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewState
import br.com.messore.tech.lightning.nodes.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NodesScreen(
    state: NodesViewState,
    onIntent: (NodesViewIntent) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background),
    ) {
        OrderNode(onIntent, state)

        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.small),
            contentPadding = PaddingValues(AppTheme.spacing.medium),
        ) {
            items(state.nodes) { node ->
                NodeItem(node)
            }
        }
    }
}

@Composable
@PreviewLightDark
private fun NodesScreenPreview() {
    AppTheme {
        NodesScreen(
            state = PreviewFactory.nodeViewState(),
            onIntent = {},
        )
    }
}
