package com.nostr.jmostr

object DMCrypto {
    fun encrypt(message: String): String {
        return "encrypted: $message"
    }

    fun decrypt(message: String): String {
        return "decrypted: $message"
    }
}
