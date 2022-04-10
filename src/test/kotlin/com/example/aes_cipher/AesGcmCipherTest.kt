package com.example.aes_cipher

import org.apache.commons.codec.binary.Hex
import java.security.SecureRandom
import java.util.*
import kotlin.test.Test

class AesGcmCipherTest {
    private val secureRandom = SecureRandom()

    @Test
    fun test() {
        repeat(IntRange(1, 100).count()) {
            // Randomize key size
            val key = ByteArray(intArrayOf(16, 24, 32).random())
            // Make random key
            secureRandom.nextBytes(key)
            // Make cipher instance
            val aesGcmCipher = AesGcmCipher(key)

            // Make random plain
            val plain = ByteArray(secureRandom.nextInt(65535))
            secureRandom.nextBytes(plain)

            // encrypt
            val encrypted = aesGcmCipher.encrypt(plain)
            val decrypted = aesGcmCipher.decrypt(encrypted)
            assert(plain contentEquals decrypted)

            // encrypt as Base64
            val plainBase64 = Base64.getEncoder().encodeToString(plain)
            val encryptedBase64 = aesGcmCipher.encryptAsBase64(plainBase64)
            val decryptedBase64 = aesGcmCipher.decryptAsBase64(encryptedBase64)
            assert(plainBase64 contentEquals decryptedBase64)

            // encrypt as Hex string
            val plainHex = Hex.encodeHexString(plain)
            val encryptedHex = aesGcmCipher.encryptAsHex(plainHex)
            val decryptedHex = aesGcmCipher.decryptAsHex(encryptedHex)
            assert(plainHex contentEquals decryptedHex)
        }
    }

    @Test
    fun test2() {
        repeat(IntRange(1, 100).count()) {
            // Randomize key size
            val key = ByteArray(intArrayOf(16, 24, 32).random())
            // Make random key
            secureRandom.nextBytes(key)

            // Randomize tag length
            val tagBitLen = listOf(128, 120, 112, 104, 96).random()
            // Randomize AAD
            val aad = ByteArray(secureRandom.nextInt(64 * 1024))
            secureRandom.nextBytes(aad)

            // Make cipher instance
            val aesGcmCipher = AesGcmCipher(key, tagBitLen, aad)

            // Make random plain
            val plain = ByteArray(secureRandom.nextInt(65535))
            secureRandom.nextBytes(plain)

            // encrypt
            val encrypted = aesGcmCipher.encrypt(plain)
            val decrypted = aesGcmCipher.decrypt(encrypted)
            assert(plain contentEquals decrypted)
        }
    }
}
