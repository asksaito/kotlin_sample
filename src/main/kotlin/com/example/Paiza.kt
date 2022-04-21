package com.example

import kotlin.math.sqrt


fun paizaLerning1(args: Array<String>) {
    val input = readLine()!!.split(" ")

    val distance = input[0].toInt()
    val stride = input[1].toInt()

    when {
        distance * 1000 * 100 >= stride * 10000 -> println("yes")
        else -> println("no")
    }
}

fun paizaLerning2(args: Array<String>) {
    val input = readLine()!!.toInt()
    val degrees = 180 * (input - 2)
    val output = degrees / input

    println(output)
}

fun main222(args: Array<String>) {
    val input = readLine()!!.split(" ")

    val distance = input[0].toInt()
    val stride = input[1].toInt()

    when {
        distance * 1000 * 100 >= stride * 10000 -> println("yes")
        else -> println("no")
    }
}

// 8
// 174
// 93762
fun primeFactorization(args: Array<String>) {
    var input = readLine()!!.trim().toLong()
    val result = mutableListOf<Long>()

    val primeList = generatePrimes(input)
    for (prime in primeList) {
        if (prime >= input) break

        while (input != prime && input % prime == 0L) {
            input /= prime
            result.add(prime)
        }
    }
    result.add(input)

    result.forEach { println(it) }
}

fun generatePrimes(max: Long): List<Long> {
    val primeList = mutableListOf<Long>()
    if (max < 2) {
        return primeList
    }

    val searchList = LongRange(2, max).toMutableList()
    val sqrtMax = sqrt(max.toDouble()).toLong()
    do {
        val prime = searchList[0]
        primeList.add(prime)

        searchList.removeIf { it % prime == 0L }
    } while (prime < sqrtMax)

    primeList.addAll(searchList)
    return primeList
}
