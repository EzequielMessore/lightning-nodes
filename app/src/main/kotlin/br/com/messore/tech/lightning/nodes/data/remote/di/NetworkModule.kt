package br.com.messore.tech.lightning.nodes.data.remote.di

import br.com.messore.tech.lightning.nodes.data.remote.api.NodeApi
import br.com.messore.tech.lightning.nodes.data.remote.service.NodeService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::createHttpClient)
    singleOf(::NodeApi)
        .bind<NodeService>()
}
