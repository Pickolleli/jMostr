package com.nostr.jmostr

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

object Amber {
    class SignContract : ActivityResultContract<String, String?>() {
        override fun createIntent(context: Context, input: String): Intent =
            Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(android.net.Uri.parse("amber://sign_event"), null)
                putExtra("event", input)
            }

        override fun parseResult(resultCode: Int, intent: Intent?): String? =
            intent?.getStringExtra("signature")
    }
}
