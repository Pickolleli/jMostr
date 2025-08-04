package com.nostr.jmostr.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nostr.jmostr.R
import com.nostr.jmostr.utils.KeyManager

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editText = findViewById<EditText>(R.id.etNsec)
        val loginButton = findViewById<Button>(R.id.btnNsec)
        val amberButton = findViewById<Button>(R.id.btnAmber)

        loginButton.setOnClickListener {
            val nsec = editText.text.toString().trim()
            if (!nsec.startsWith("nsec1")) {
                Toast.makeText(this, "Formato NSEC non valido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                val hexKey = nsec.removePrefix("nsec1")
                val key = hexKey.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
                KeyManager.store(key)
                startActivity(Intent(this, FeedActivity::class.java))
                finish()
            } catch (e: Exception) {
                Toast.makeText(this, "NSEC non valido: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        amberButton.setOnClickListener {
            Toast.makeText(this, "Login con Amber non ancora implementato", Toast.LENGTH_SHORT).show()
        }
    }
}
