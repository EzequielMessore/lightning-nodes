package br.com.messore.tech.lightning.nodes.ui.theme

import androidx.compose.ui.graphics.Color

object BrandColor {
    val Update = Color(0XFF9A00FF)
}

object DarkColors {
    val Background = Color(0xFF121212)
    val Text = Color(0xFFFFFFFF)
    val CardBackground = Color(0xFF1F1F1F)
    val Capacity = Color(0XFFA3FF00)
    val Main = Color(0xFFFFB900)
}

fun darkColors() = Colors(
    isLight = false,
    main = DarkColors.Main,
    background = DarkColors.Background,
    text = DarkColors.Text,
    cardBackground = DarkColors.CardBackground,
    capacity = DarkColors.Capacity,
    update = BrandColor.Update,
)

object LightColors {
    val Background = Color(0xFFF9FAFB)
    val Text = Color(0xFF1F2937)
    val CardBackground = Color(0xFFFFFFFF)
    val Capacity = Color(0XFF10B981)
    val Main = Color(0xFFF7931A)
}

fun lightColors() = Colors(
    isLight = true,
    main = LightColors.Main,
    background = LightColors.Background,
    text = LightColors.Text,
    cardBackground = LightColors.CardBackground,
    capacity = LightColors.Capacity,
    update = BrandColor.Update,
)
