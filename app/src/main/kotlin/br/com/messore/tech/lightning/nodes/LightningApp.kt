package br.com.messore.tech.lightning.nodes

import android.app.Application
import br.com.messore.tech.lightning.nodes.data.data.di.dataModule
import br.com.messore.tech.lightning.nodes.data.remote.di.networkModule
import br.com.messore.tech.lightning.nodes.presentation.di.presentationModule
import org.koin.core.context.startKoin
import br.com.messore.tech.lightning.nodes.core.DispatchersProvider

class LightningApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    dataModule,
                    networkModule,
                    presentationModule,
                ),
            )
        }
    }
}
