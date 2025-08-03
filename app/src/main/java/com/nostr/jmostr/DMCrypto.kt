package com.nostr.jmostr

import fr.acinq.secp256k1.Secp256k1
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object DMCrypto {
    private val secp = Secp256k1.get()
    private val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")

    fun encryptDM(plain: ByteArray, priv: ByteArray, pub: ByteArray): ByteArray {
        val shared = secp.ecdh(pub, priv)
        val key = shared.copyOfRange(0, 32)
        val iv = ByteArray(16).also { SecureRandom().nextBytes(it) }
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))
        return iv + cipher.doFinal(plain)
    }

    fun decryptDM(cipherBytes: ByteArray, priv: ByteArray, pub: ByteArray): ByteArray {
        val shared = secp.ecdh(pub, priv)
        val key = shared.copyOfRange(0, 32)
        val iv = cipherBytes.copyOfRange(0, 16)
        val ct = cipherBytes.copyOfRange(16, cipherBytes.size)
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))
        return cipher.doFinal(ct)
    }
}
