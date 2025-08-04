package com.nostr.jmostr.utils

object KeyManager {
    private var privKey: ByteArray? = null

    fun store(key: ByteArray) { privKey = key }
    fun get(): ByteArray = privKey ?: throw IllegalStateException("No key")
}
