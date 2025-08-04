package com.nostr.jmostr.network

import android.util.Log
import okhttp3.*
import java.util.concurrent.TimeUnit

class RelayPool {
    private val client = OkHttpClient.Builder()
        .pingInterval(30, TimeUnit.SECONDS).build()

    val defaultRelays = listOf(
        "wss://relay.damus.io",
        "wss://nos.lol",
        "wss://relay.primal.net"
    )

    private val sockets = mutableMapOf<String, WebSocket>()

    fun connect() = defaultRelays.forEach { url ->
        val ws = client.newWebSocket(Request.Builder().url(url).build(),
            object : WebSocketListener() {
                override fun onMessage(ws: WebSocket, text: String) {
                    Log.d("RelayPool", "RX: $text")
                }
            })
        sockets[url] = ws
    }

    fun subscribe() {
        val sub = """["REQ","sub1",{"kinds":[1,4],"limit":50}]"""
        sockets.values.forEach { it.send(sub) }
    }

    fun closeAll() = sockets.values.forEach { it.close(1000, "bye") }
}
