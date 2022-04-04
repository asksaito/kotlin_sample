package com.example.encouragement_of_kotlin

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
import java.time.temporal.ChronoUnit
import java.util.Date

data class User(val name: String, val age: Int)

class KotlinSample {
    fun example(name: String) {
        println("Hello!! $name さん")
    }

    fun example2(name: String, birthday: LocalDate) {
        println("名前: $name / 生年月日: ${birthday.format(ISO_LOCAL_DATE)} / " +
                "年齢: ${ChronoUnit.YEARS.between(birthday, LocalDate.now())}")
    }

    fun example3(user: User) {
        // JavaのGetterのようなもの
        println("name: ${user.name} / age: ${user.age}")
        // 自動生成されたtoStringメソッド
        println(user.toString())
    }

    fun example4() {
        val immutableList = listOf("a", "bb", "ccc")
        val immutableMap = mapOf(1 to "ONE", 2 to "TWO", 3 to "THREE")

        val mutableList = mutableListOf("a", "bb", "ccc")
        val mutableMap = mutableMapOf(1 to "ONE", 2 to "TWO", 3 to "THREE")

        // Mutableの場合のみ、コレクションの変更が可能
        mutableList.add("dddd")
        mutableMap[4] = "FOUR"
    }

    fun example5(domain: String) {
        when (domain) {
            "google.co.jp" -> println("Google")
            "yahoo.co.jp", "yahoo.com" -> println("Yahoo")
            "4engineer.net" -> println("プログラミング初心者のためのブログ")
            else -> println("Unknown")
        }
    }

    fun example6(num: Int): String {
        // whenの後ろにカッコが付かないパターン
        return when { // 式なのでそのままリターンできる
            num < 0 -> "負数"
            num == 0 -> "ゼロ"
            else -> "正数"
        }
    }

    fun example7() {
        // 返り値で二値、三値を受け取るパターン
        val (num, str) = returnPair()
        val (num2, str2, kanji) = returnTriple()
        println("$num, $str")
        println("$num2, $str2, $kanji")

        // Pair, Tripleとして受け取ることもできる
        val pair = returnPair()
        val triple = returnTriple()
        println("${pair.first}, ${pair.second}")
        println("${triple.first}, ${triple.second}, ${triple.third}")
    }

    private fun returnPair(): Pair<Int, String> {
        return Pair(1, "ONE")
    }

    private fun returnTriple(): Triple<Int, String, String> {
        return Triple(1, "ONE", "一")
    }

    fun example8(hello: String, helloNullable: String?) { // Null許容型は型の後ろに?が付きます
        // Null非許容型の hello は絶対にnullにならないことが保証されるので比較的安全です
        // 基本的にはNull非許容型を優先的に使う方が良い
        println(hello)

        // エルビス演算子
        val helloNotNull = helloNullable ?: "こんにちは" // helloNullableが nullの場合、"こんにちは"が代入される
        println(helloNotNull)

        // let演算子
        helloNullable?.let {
            // helloNullableが nullじゃない場合のみ実行される
            println(it)
        }
    }

    fun example9() {
        // 全てデフォルト値を使うパターン
        defaultParam()
        // 第三引数を省略するパターン
        defaultParam("ゴイチ", 42)
        // 第三引数のみ指定するパターン
        defaultParam(date = LocalDate.of(2022, 12, 31))
        // 記述の順番を変えることもできます
        defaultParam(age = 42, date = LocalDate.of(2022, 12, 31), name = "ゴイチ")
    }

    private fun defaultParam(name: String = "デフォルト名", age: Int = 20, date: LocalDate = LocalDate.now()) {
        println("$name, $age, $date")
    }

    fun example10(obj: Any) {
        if (obj is String) { // スマートキャスト
            // is で判定後は、obj は String と見なされる
            println(obj)
        }
    }

    fun example11() {
        // 文字列に Prefix と Suffix を付加する拡張関数
        val str = "こんにちは".addPrefixSuffix("<<<", ">>>")
        println(str)

        // Date -> LocalDateTime に変換する拡張関数
        val localDateTime = Date().toLocalDateTime()
        println(localDateTime)
    }

    // Stringの拡張関数
    fun String.addPrefixSuffix(prefix: String, suffix: String): String {
        return "$prefix$this$suffix"
    }

    // Dateの拡張関数
    fun Date.toLocalDateTime(): LocalDateTime {
        return this.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()
    }

    fun example12() {
        val list = IntRange(1, 10) // 1～10の数値
            .map { it * 2 } // 2倍する
            .toList()

        println(list)
    }
}
