package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.messore.tech.lightning.nodes.ui.theme.AppImagesDefault
import br.com.messore.tech.lightning.nodes.ui.theme.AppTheme

@Composable
internal fun ErrorScreen(
    onRetry: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
            .padding(AppTheme.spacing.small),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = AppImagesDefault.AlertHexagon,
            contentDescription = "Erro",
            modifier = Modifier.size(width = 59.dp, height = 52.dp),
            tint = AppTheme.colors.main,
        )

        Spacer(
            modifier = Modifier.height(AppTheme.spacing.medium),
        )

        Text(
            text = "Algo deu errado ao tentar carregar os dados",
            style = AppTheme.typography.body.copy(
                color = AppTheme.colors.text,
            ),
        )

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = onRetry,
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = AppTheme.colors.background,
                contentColor = AppTheme.colors.main,
            ),
        ) {
            Text(text = "Tentar novamente")
        }
    }
}

@Composable
@PreviewLightDark
private fun ErrorScreenPreview() {
    AppTheme {
        ErrorScreen(
            onRetry = {},
        )
    }
}
