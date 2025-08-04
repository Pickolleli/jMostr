package com.nostr.jmostr.model

import kotlinx.serialization.Serializable

@Serializable
data class NostrEvent(
    val id: String,
    val pubKey: String,
    val createdAt: Long,
    val kind: Int,
    val tags: List<List<String>>,
    val content: String,
    val sig: String
)
