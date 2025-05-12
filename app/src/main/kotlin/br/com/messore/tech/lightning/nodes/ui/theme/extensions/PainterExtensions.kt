package br.com.messore.tech.lightning.nodes.ui.theme.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource

@Composable
fun ImageVector.asPainter(): Painter {
    return rememberVectorPainter(this)
}

@Composable
fun Painter.tint(color: Color) = apply {
    ColorFilter.tint(color)
}

@Composable
fun Int.asImageVector(): ImageVector {
    return vectorResource(id = this)
}

@Composable
internal fun vectorResource(id: Int): ImageVector {
    return ImageVector.vectorResource(id = id)
}
