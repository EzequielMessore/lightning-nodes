package br.com.messore.tech.lightning.nodes.presentation.feature.nodes.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import br.com.messore.tech.lightning.nodes.R
import br.com.messore.tech.lightning.nodes.domain.model.Node
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.preview.PreviewFactory
import br.com.messore.tech.lightning.nodes.ui.theme.AppImagesDefault
import br.com.messore.tech.lightning.nodes.ui.theme.AppTheme

@Composable
internal fun NodeItem(
    node: Node,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.cardBackground,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppTheme.spacing.small,
        ),
    ) {
        Column(
            modifier = Modifier.padding(AppTheme.spacing.small),
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.extraSmall),
        ) {
            NodeInfoRow(
                image = null,
                text = stringResource(R.string.alias, node.alias),
                style = AppTheme.typography.title.copy(
                    color = AppTheme.colors.text,
                ),
            )

            Spacer(Modifier.height(AppTheme.spacing.small))

            NodeInfoRow(
                image = AppImagesDefault.Key,
                text = stringResource(R.string.public_key, node.formattedPublicKey),
                style = AppTheme.typography.body.copy(
                    color = AppTheme.colors.text,
                ),
            )

            NodeInfoRow(
                image = AppImagesDefault.Chart,
                text = stringResource(R.string.channels, node.channels),
                style = AppTheme.typography.body.copy(
                    color = AppTheme.colors.text,
                ),
            )

            NodeInfoRow(
                image = AppImagesDefault.Bitcoin,
                text = stringResource(R.string.capacity, node.capacity),
                style = AppTheme.typography.body.copy(
                    color = AppTheme.colors.capacity,
                ),
            )

            Spacer(Modifier.height(AppTheme.spacing.small))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.small),
            ) {
                Icon(
                    imageVector = AppImagesDefault.Calendar,
                    contentDescription = null,
                    tint = AppTheme.colors.main,
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.first_seen, node.firstSeen),
                        style = AppTheme.typography.caption.copy(
                            color = AppTheme.colors.text,
                        ),
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.last_update, node.updatedAt),
                        style = AppTheme.typography.caption.copy(
                            color = AppTheme.colors.text,
                        ),
                    )
                }
            }

            Spacer(Modifier.height(AppTheme.spacing.small))

            node.location?.let { location ->
                Row(
                    modifier = Modifier.align(Alignment.End),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.small),
                ) {
                    Icon(
                        imageVector = AppImagesDefault.Location,
                        contentDescription = null,
                        tint = AppTheme.colors.main,
                    )
                    Text(
                        text = stringResource(R.string.location, location),
                        style = AppTheme.typography.caption.copy(
                            color = AppTheme.colors.text,
                        ),
                    )
                }
            }
        }
    }
}

@Composable
private fun NodeInfoRow(
    text: String,
    style: TextStyle,
    image: ImageVector?,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.small),
    ) {
        image?.let {
            Icon(
                imageVector = image,
                contentDescription = null,
                tint = AppTheme.colors.main,
            )
        }

        Text(
            text = text,
            style = style,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
@PreviewLightDark
private fun NodeItemPreview() {
    AppTheme {
        NodeItem(
            node = PreviewFactory.nodeViewState().nodes.first(),
        )
    }
}
