package com.example.kotlin_hash

import org.apache.commons.codec.digest.DigestUtils
import java.security.MessageDigest


fun sha3(input: ByteArray): ByteArray {
    val md = MessageDigest.getInstance("SHA3-512")
    return md.digest(input)
}

fun sha256(input: ByteArray): ByteArray {
    val md = MessageDigest.getInstance("SHA-256")
    return md.digest(input)
}

fun sha1(input: ByteArray): ByteArray {
    val md = MessageDigest.getInstance("SHA-1")
    return md.digest(input)
}

fun md5(input: ByteArray): ByteArray {
    val md = MessageDigest.getInstance("MD5")
    return md.digest(input)
}


fun sha3Commons(input: ByteArray): ByteArray {
    return DigestUtils.sha3_512(input)
}

fun sha256Commons(input: ByteArray): ByteArray {
    return DigestUtils.sha256(input)
}

fun sha1Commons(input: ByteArray): ByteArray {
    return DigestUtils.sha1(input)
}

fun md5Commons(input: ByteArray): ByteArray {
    return DigestUtils.md5(input)
}