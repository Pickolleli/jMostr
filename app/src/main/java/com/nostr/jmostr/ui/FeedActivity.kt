// Crea un nuovo file in: app/src/main/java/com/nostr/jmostr/ui/FeedActivity.kt
package com.nostr.jmostr.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nostr.jmostr.R
import com.nostr.jmostr.utils.KeyManager

class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        if (KeyManager.getKey() == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }
        
        setContentView(R.layout.activity_feed)
    }
}
