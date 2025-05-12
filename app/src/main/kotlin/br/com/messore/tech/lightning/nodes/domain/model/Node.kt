package br.com.messore.tech.lightning.nodes.domain.model

data class Node(
    val alias: String,
    val channels: Int,
    val capacity: String,
    val location: String?,
    val firstSeen: String,
    val updatedAt: String,
    val publicKey: String,
) {
    val formattedPublicKey: String
        get() = if (publicKey.length > 16) {
            "${publicKey.take(8)}...${publicKey.takeLast(8)}"
        } else {
            publicKey
        }
}
