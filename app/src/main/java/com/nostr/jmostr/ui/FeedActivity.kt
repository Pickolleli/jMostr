package com.nostr.jmostr.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nostr.jmostr.R
import com.nostr.jmostr.network.RelayPool

class FeedActivity : AppCompatActivity() {
    private val relayPool = RelayPool()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        relayPool.connect()
        relayPool.subscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        relayPool.closeAll()
    }
}
