package com.nostr.jmostr.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nostr.jmostr.utils.KeyManager
import android.widget.EditText
import android.widget.Button

setContentView(R.layout.activity_login)

val editText = findViewById<EditText>(R.id.etNsec)
val loginButton = findViewById<Button>(R.id.btnNsec)
val amberButton = findViewById<Button>(R.id.btnAmber)

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btnNsec).setOnClickListener {
            val nsec = findViewById<EditText>(R.id.etNsec).text.toString()
            try {
                val key = nsec.drop(4).decodeHex()
                KeyManager.store(key)
                startActivity(Intent(this, FeedActivity::class.java))
                finish()
            } catch (e: Exception) {
                Toast.makeText(this, "Nsec non valido", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnAmber).setOnClickListener {
            // Lancia intent Amber (NIP-07)
            startActivity(Intent(this, FeedActivity::class.java))
            finish()
        }
    }
}

fun String.decodeHex(): ByteArray = chunked(2).map { it.toInt(16).toByte() }.toByteArray()
