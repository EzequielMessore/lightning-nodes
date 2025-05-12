package br.com.messore.tech.lightning.nodes.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

class Colors(
    isLight: Boolean,
    main: Color,
    background: Color,
    text: Color,
    cardBackground: Color,
    capacity: Color,
    update: Color,
) {
    val isLight by mutableStateOf(isLight)

    val main by mutableStateOf(main)
    val background by mutableStateOf(background)
    val text by mutableStateOf(text)
    val cardBackground by mutableStateOf(cardBackground)

    val capacity by mutableStateOf(capacity)
    val update by mutableStateOf(update)

    fun updateColorsFrom(other: Colors) = Colors(
        isLight = other.isLight,
        main = other.main,
        background = other.background,
        text = other.text,
        cardBackground = other.cardBackground,
        capacity = other.capacity,
        update = other.update,
    )
}
