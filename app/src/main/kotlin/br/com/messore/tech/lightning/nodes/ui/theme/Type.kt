package br.com.messore.tech.lightning.nodes.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.messore.tech.lightning.nodes.R

private val DefaultFontFamily = FontFamily(
    Font(R.font.space_grotesk, FontWeight.Normal),
    Font(R.font.space_grotesk_bold, FontWeight.Bold),
    Font(R.font.space_grotesk_light, FontWeight.Light),
    Font(R.font.space_grotesk_medium, FontWeight.Medium),
    Font(R.font.space_grotesk_semibold, FontWeight.SemiBold),
)

private val Default = TextStyle(
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp,
    fontFamily = DefaultFontFamily,
)

data class AppTypography(
    val title: TextStyle = Default.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
    ),
    val body: TextStyle = Default.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
    ),
    val caption: TextStyle = Default.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
    ),
)

val LocalTypography = staticCompositionLocalOf { AppTypography() }
