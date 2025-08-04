package com.nostr.jmostr.model

import java.io.Serializable

data class NostrEvent(
    val id: String,
    val pubkey: String,
    val created_at: Long,
    val kind: Int,
    val tags: List<List<String>>,
    val content: String,
    val sig: String
) : Serializable
