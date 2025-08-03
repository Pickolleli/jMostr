package com.nostr.jmostr

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btn = Button(this).apply { text = "Hello jMostr" }
        setContentView(btn)
        btn.setOnClickListener {
            Toast.makeText(this, "Nostr client ready", Toast.LENGTH_SHORT).show()
        }
    }
}
