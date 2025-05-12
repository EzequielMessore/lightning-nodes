package br.com.messore.tech.lightning.nodes.data.data.di

import br.com.messore.tech.lightning.nodes.data.data.repository.NodeRepositoryImpl
import br.com.messore.tech.lightning.nodes.domain.repository.NodeRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::NodeRepositoryImpl)
        .bind<NodeRepository>()
}
