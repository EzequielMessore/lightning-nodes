package br.com.messore.tech.lightning.nodes.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NodeRemote(
    @SerialName("publicKey")
    val publicKey: String,
    @SerialName("alias")
    val alias: String,
    @SerialName("channels")
    val channels: Int,
    @SerialName("capacity")
    val capacity: Double,
    @SerialName("firstSeen")
    val firstSeen: Long,
    @SerialName("updatedAt")
    val updatedAt: Long,
    @SerialName("city")
    val city: Map<String, String>?,
    @SerialName("country")
    val country: Map<String, String>?,
)
