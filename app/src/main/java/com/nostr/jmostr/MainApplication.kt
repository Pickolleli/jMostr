// Crea se non esiste: app/src/main/java/com/nostr/jmostr/MainApplication.kt
package com.nostr.jmostr

import android.app.Application
import com.nostr.jmostr.utils.KeyManager

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KeyManager.init(this)
    }
}
