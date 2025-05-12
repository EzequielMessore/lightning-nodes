package br.com.messore.tech.lightning.nodes.extensions

/**
 * was created the extension normalize because the formater from java return   like a space
 */
fun String.normalize() = replace("\u202F", " ")
