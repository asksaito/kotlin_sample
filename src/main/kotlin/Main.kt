import com.example.aes_cipher.AesGcmCipher
import com.example.encouragement_of_kotlin.KotlinSample
import com.example.encouragement_of_kotlin.User
import com.example.map_vs_flatmap.MapVsFlatMap
import java.security.SecureRandom
import java.time.LocalDate
import java.util.*

fun main(/*args: Array<String>*/) {
//    println("Hello World!")

//    var intput: String? = null
//    val size = 4
//    println("$intput -> ${mask(intput, size)}")
//
//    intput = ""
//    println("$intput -> ${mask(intput, size)}")
//
//    intput = "4en"
//    println("$intput -> ${mask(intput, size)}")
//
//    intput = "4eng"
//    println("$intput -> ${mask(intput, size)}")
//
//    intput = "4engineer.net"
//    println("$intput -> ${mask(intput, size)}")
//
//    intput = "1234-5678-9012-3456"
//    println("$intput -> ${mask(intput, size)}")
//
//    println("$intput -> ${rightMask(intput, size)}")

//    val sample = KotlinSample()
//    sample.example("ゴイチ")
//    sample.example2("ゴイチ", LocalDate.of(1980, 1, 1))
//    sample.example3(User("ゴイチ", 100))
//    sample.example4()
//    sample.example5("4engineer.net")
//    sample.example6(-1)
//    sample.example7()
//    sample.example8("Hello!!", "こん!")
//    sample.example9()
//    sample.example10("スマートキャストされた文字列です")
//    sample.example11()
//    sample.example12()

//    val mapVsFlatMap = MapVsFlatMap()
//    mapVsFlatMap.example()
//    mapVsFlatMap.example2()
//    mapVsFlatMap.example3()

    val plainText = "This is a plain text."
    val keyBase64 = "XkbPC5uQWTF6UWFx/FeRjlZPaqQtQqRKLt6lbZsbQf4="

    // Generate Cipher instance
    val key = Base64.getDecoder().decode(keyBase64) // key as binary data
    val cipher = AesGcmCipher(key) // tagLen is default 128bit, no AAD

    // Encryption
    val encryptData = cipher.encrypt(plainText.toByteArray())

    // Decryption
    val decryptData = cipher.decrypt(encryptData)

    println("Decrypt Text: ${String(decryptData)}")
    // Decrypt Text: This is a plain text.
}