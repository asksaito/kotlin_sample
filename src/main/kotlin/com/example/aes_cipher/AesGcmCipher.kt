package com.example.aes_cipher

import org.apache.commons.codec.binary.Hex
import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

class AesGcmCipher {
    private val GCM_CIPHER_MODE = "AES/GCM/NoPadding" // Cipher mode
    private val GCM_NONCE_LENGTH = 12 // Nonce length
    private val GCM_AAD_MAX_LENGTH = 64 * 1024 // AAD Max length

    private val key: SecretKey
    private val tagBitLen: Int
    private val aad: ByteArray?
    private val random = SecureRandom()

    constructor(key: ByteArray, tagBitLen: Int = 128, aad: ByteArray? = null) {
        assert(listOf(128, 192, 256).contains(key.size * 8)) // Must be one of {128, 192, 256} bit len
        assert(listOf(128, 120, 112, 104, 96).contains(tagBitLen)) // Must be one of {128, 120, 112, 104, 96} bit len
        aad?.let { assert(it.size < GCM_AAD_MAX_LENGTH) } // Must be less than 64KiB

        this.key = SecretKeySpec(key, "AES")
        this.tagBitLen = tagBitLen
        this.aad = aad
    }

    fun encrypt(plainData: ByteArray): ByteArray {
        // Generate Cipher Instance
        val cipher = generateCipher(Cipher.ENCRYPT_MODE)

        // Perform Encryption
        val encryptData = cipher.doFinal(plainData)

        // Return nonce + Encrypt Data
        return cipher.iv + encryptData
    }

    fun decrypt(cipherData: ByteArray): ByteArray {
        val nonce = cipherData.copyOfRange(0, GCM_NONCE_LENGTH)
        val encryptData = cipherData.copyOfRange(GCM_NONCE_LENGTH, cipherData.size)

        // Generate Cipher Instance
        val cipher = generateCipher(Cipher.DECRYPT_MODE, nonce)

        // Perform Decryption
        return cipher.doFinal(encryptData)
    }

    fun encryptAsBase64(plainTextBase64: String): String {
        return Base64.getEncoder().encodeToString(
            encrypt(Base64.getDecoder().decode(plainTextBase64))
        )
    }

    fun decryptAsBase64(cipherTextBase64: String): String {
        return Base64.getEncoder().encodeToString(
            decrypt(Base64.getDecoder().decode(cipherTextBase64))
        )
    }

    fun encryptAsHex(plainTextHex: String): String {
        return Hex.encodeHexString(
            encrypt(Hex.decodeHex(plainTextHex))
        )
    }

    fun decryptAsHex(cipherTextHex: String): String {
        return Hex.encodeHexString(
            decrypt(Hex.decodeHex(cipherTextHex))
        )
    }

    private fun generateCipher(mode: Int, nonceToDecrypt: ByteArray? = null): Cipher {
        // Get Cipher Instance
        val cipher = Cipher.getInstance(GCM_CIPHER_MODE)

        // Get nonce
        val nonce = when (mode) {
            Cipher.ENCRYPT_MODE -> {
                // Generate nonce
                val nonceToEncrypt = ByteArray(GCM_NONCE_LENGTH)
                random.nextBytes(nonceToEncrypt)
                nonceToEncrypt
            }
            Cipher.DECRYPT_MODE -> {
                nonceToDecrypt ?: throw IllegalArgumentException()
            }
            else -> throw IllegalArgumentException()
        }

        // Create GCMParameterSpec
        val gcmParameterSpec = GCMParameterSpec(tagBitLen, nonce)

        // Initialize Cipher with mode/key/iv
        cipher.init(mode, key, gcmParameterSpec)
        aad?.let {
            // Update AAD to do additional auth (Optional)
            cipher.updateAAD(it)
        }

        return cipher
    }
}
