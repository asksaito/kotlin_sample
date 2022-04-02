package com.example.encouragement_of_kotlin

import java.time.LocalDate
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
import java.time.temporal.ChronoUnit

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
}
