package br.com.messore.tech.lightning.nodes.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <R> execute(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    execute: suspend () -> R,
    onSuccess: (R) -> Unit = {},
    onFailure: Throwable.() -> Unit = {},
) {
    runCatching {
        withContext(dispatcher) { execute() }
    }.onSuccess(onSuccess).onFailure(onFailure)
}
