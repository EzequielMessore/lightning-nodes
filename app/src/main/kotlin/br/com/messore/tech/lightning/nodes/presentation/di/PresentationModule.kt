package br.com.messore.tech.lightning.nodes.presentation.di

import br.com.messore.tech.lightning.nodes.core.DispatchersProvider
import br.com.messore.tech.lightning.nodes.presentation.feature.nodes.view.model.NodesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    single { DispatchersProvider() }
    viewModelOf(::NodesViewModel)
}
