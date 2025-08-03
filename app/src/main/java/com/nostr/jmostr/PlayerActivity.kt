package com.nostr.jmostr

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class PlayerActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url = intent.getStringExtra("url") ?: return finish()
        val playerView = PlayerView(this)
        player = ExoPlayer.Builder(this).build()
        playerView.player = player
        setContentView(playerView)
        player.setMediaItem(com.google.android.exoplayer2.MediaItem.fromUri(Uri.parse(url)))
        player.prepare()
        player.play()
    }
    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}
