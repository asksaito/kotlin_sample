import com.example.aes_cipher.AesGcmCipher
import com.example.csv.bomCsvParse
import com.example.csv.readCsvAsList
import com.example.csv.readCsvAsMap
import com.example.encouragement_of_kotlin.KotlinSample
import com.example.encouragement_of_kotlin.User
import com.example.generatePrimes
import com.example.kotlin_hash.*
import com.example.map_vs_flatmap.MapVsFlatMap
import com.example.object_declarations.CompanionObject
import com.example.object_declarations.ObjectDeclaration
import com.example.primeFactorization
import com.example.sort.sortSample
import com.example.sort.sortSample2
import org.apache.commons.codec.binary.Hex
import java.nio.charset.StandardCharsets
import java.security.SecureRandom
import java.time.LocalDate
import java.util.*

//val objectDeclaration = ObjectDeclaration //objectはインスタンス生成できない
val companionObject = CompanionObject()

fun main(args: Array<String>) {
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

//    primeFactorization(args)
//    println(generatePrimes(120))
//    println(generatePrimes(1000000).size)

//    val plainText = "This is a plain text."
//    val keyBase64 = "XkbPC5uQWTF6UWFx/FeRjlZPaqQtQqRKLt6lbZsbQf4="
//
//    // Generate Cipher instance
//    val key = Base64.getDecoder().decode(keyBase64) // key as binary data
//    val cipher = AesGcmCipher(key) // tagLen is default 128bit, no AAD
//
//    // Encryption
//    val encryptData = cipher.encrypt(plainText.toByteArray())
//
//    // Decryption
//    val decryptData = cipher.decrypt(encryptData)
//
//    println("Decrypt Text: ${String(decryptData)}")
//    // Decrypt Text: This is a plain text.

//    val input = "This is a input text."
//    val sb = StringBuilder()
//    repeat(LongRange(1, 10000000L).count()) { sb.append(it) }
//    val input = sb.toString()
//
//    val sha3result = sha3(input.toByteArray(StandardCharsets.UTF_8))
//    val sha3CommonsResult = sha3Commons(input.toByteArray(StandardCharsets.UTF_8))
//    println("${Hex.encodeHexString(sha3result)}")
//    println("${Hex.encodeHexString(sha3CommonsResult)}")
//    println("Sha3 Result: " + (sha3result contentEquals sha3CommonsResult))
//
//    val sha2result = sha256(input.toByteArray(StandardCharsets.UTF_8))
//    val sha2CommonsResult = sha256Commons(input.toByteArray(StandardCharsets.UTF_8))
//    println("${Hex.encodeHexString(sha2result)}")
//    println("${Hex.encodeHexString(sha2CommonsResult)}")
//    println("Sha2 Result: " + (sha2result contentEquals sha2CommonsResult))
//
//    val sha1result = sha1(input.toByteArray(StandardCharsets.UTF_8))
//    val sha1CommonsResult = sha1Commons(input.toByteArray(StandardCharsets.UTF_8))
//    println("${Hex.encodeHexString(sha1result)}")
//    println("${Hex.encodeHexString(sha1CommonsResult)}")
//    println("Sha1 Result: " + (sha1result contentEquals sha1CommonsResult))
//
//    val md5result = md5(input.toByteArray(StandardCharsets.UTF_8))
//    val md5CommonsResult = md5Commons(input.toByteArray(StandardCharsets.UTF_8))
//    println("${Hex.encodeHexString(md5result)}")
//    println("${Hex.encodeHexString(md5CommonsResult)}")
//    println("md5 Result: " + (md5result contentEquals md5CommonsResult))
//
//    sortSample()
//    sortSample2()
//
//    readCsvAsList("D:\\temp\\test\\GameHardWithBOM.csv")
//    readCsvAsMap("D:\\temp\\test\\GameHardWithBOMWithHeader.csv", doubleQuote = true)

    Thread.sleep(3000) // wait for 3 seconds
    ObjectDeclaration.print()
    CompanionObject.print()

}
