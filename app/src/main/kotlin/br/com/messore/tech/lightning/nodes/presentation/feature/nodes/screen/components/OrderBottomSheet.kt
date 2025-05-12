package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.messore.tech.lightning.nodes.R
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.state.NodesViewIntent
import br.com.messore.tech.lightning.nodes.ui.theme.AppTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun OrderBottomSheet(
    onDismiss: () -> Unit = {},
    onSelected: (NodesViewIntent.OrderChange.Order) -> Unit = {},
) {
    AppBottomSheet(
        showBottomSheet = true,
        onDismissRequest = onDismiss,
        content = {
            Content(
                onSelected = {
                    onSelected(it)
                    onDismiss()
                },
            )
        },
    )
}

@Composable
private fun Content(
    onSelected: (NodesViewIntent.OrderChange.Order) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppTheme.colors.cardBackground)
            .padding(AppTheme.spacing.medium),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.small),
    ) {
        Text(
            text = stringResource(R.string.order_by, ""),
            style = AppTheme.typography.title.copy(color = AppTheme.colors.text),
        )

        val entries = NodesViewIntent.OrderChange.Order.entries
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(entries) {
                Column(
                    modifier = Modifier
                        .height(AppTheme.spacing._2XL)
                        .clickable {
                            onSelected(it)
                        },
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = it.name,
                        style = AppTheme.typography.body.copy(
                            color = AppTheme.colors.text,
                        ),
                    )
                }
                HorizontalDivider()
            }
        }
    }
}

@Preview
@Composable
private fun OrderBottomSheetPreview() {
    AppTheme {
        Content()
    }
}
