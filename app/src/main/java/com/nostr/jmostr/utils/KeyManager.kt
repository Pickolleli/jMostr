// Crea un nuovo file in: app/src/main/java/com/nostr/jmostr/utils/KeyManager.kt
package com.nostr.jmostr.utils

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object KeyManager {
    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    fun store(key: ByteArray) {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        val sharedPrefs = EncryptedSharedPreferences.create(
            context,
            "nsec_secure_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        sharedPrefs.edit().putString("nsec_key", key.joinToString("") { "%02x".format(it) }).apply()
    }

    fun getKey(): ByteArray? {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        val sharedPrefs = EncryptedSharedPreferences.create(
            context,
            "nsec_secure_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        val hex = sharedPrefs.getString("nsec_key", null)
        return hex?.chunked(2)?.map { it.toInt(16).toByte() }?.toByteArray()
    }
}
