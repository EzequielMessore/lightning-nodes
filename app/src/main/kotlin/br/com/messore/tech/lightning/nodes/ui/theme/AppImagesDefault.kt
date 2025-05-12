package br.com.messore.tech.lightning.nodes.ui.theme

import androidx.compose.runtime.Composable
import br.com.messore.tech.lightning.nodes.R
import br.com.messore.tech.lightning.nodes.ui.theme.extensions.vectorResource

object AppImagesDefault {

    val AlertHexagon
        @Composable
        get() = vectorResource(id = R.drawable.ic_alert_hexagon)

    val Key
        @Composable
        get() = vectorResource(id = R.drawable.ic_key)

    val Chart
        @Composable
        get() = vectorResource(id = R.drawable.ic_chart)

    val Bitcoin
        @Composable
        get() = vectorResource(id = R.drawable.ic_bitcoin)

    val Location
        @Composable
        get() = vectorResource(id = R.drawable.ic_location)

    val Calendar
        @Composable
        get() = vectorResource(id = R.drawable.ic_calendar)
}
