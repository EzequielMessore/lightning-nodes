@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import br.com.messore.tech.lightning.nodes.ui.theme.AppTheme

@Composable
fun AppBottomSheet(
    showBottomSheet: Boolean,
    onDismissRequest: () -> Unit,
    sheetState: SheetState? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val state = sheetState ?: rememberModalBottomSheetState()

    if (showBottomSheet) {
        ModalBottomSheet(
            content = content,
            sheetState = state,
            onDismissRequest = onDismissRequest,
            containerColor = AppTheme.colors.background,
        )
    }
}
