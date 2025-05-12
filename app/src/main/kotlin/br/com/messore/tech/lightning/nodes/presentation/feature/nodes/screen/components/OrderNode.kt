package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import br.com.messore.tech.lightning.nodes.R
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.preview.PreviewFactory
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewIntent
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewState
import br.com.messore.tech.lightning.nodes.ui.theme.AppTheme
import br.com.messore.tech.lightning.nodes.ui.theme.DarkColors

@Composable
internal fun OrderNode(
    onIntent: (NodesViewIntent) -> Unit,
    state: NodesViewState,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.medium),
        horizontalArrangement = Arrangement.End,
    ) {
        Button(
            onClick = {
                onIntent(NodesViewIntent.ShowBottomSheet)
            },
        ) {
            Text(
                text = stringResource(R.string.order_by, state.order.name),
                style = AppTheme.typography.body.copy(color = DarkColors.Text),
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun OrderNodePreview() {
    AppTheme {
        OrderNode(
            onIntent = {},
            state = PreviewFactory.nodeViewState(),
        )
    }
}
