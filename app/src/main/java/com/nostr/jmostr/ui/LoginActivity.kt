// Sostituisci TUTTO il blocco del listener btnNsec con:
findViewById<Button>(R.id.btnNsec).setOnClickListener {
    val nsec = findViewById<EditText>(R.id.etNsec).text.toString().trim()
    
    if (!nsec.startsWith("nsec1")) {
        Toast.makeText(this, "Formato NSEC non valido (deve iniziare con 'nsec1')", Toast.LENGTH_SHORT).show()
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
