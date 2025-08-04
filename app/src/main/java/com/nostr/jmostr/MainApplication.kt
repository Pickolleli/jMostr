package com.nostr.jmostr

import android.app.Application
import com.nostr.jmostr.utils.KeyManager

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KeyManager.init(this)
    }
}
