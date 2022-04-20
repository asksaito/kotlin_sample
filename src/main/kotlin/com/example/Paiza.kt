package com.example

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

fun main(args: Array<String>) {
    val input = readLine()!!.split(" ")

    val distance = input[0].toInt()
    val stride = input[1].toInt()

    when {
        distance * 1000 * 100 >= stride * 10000 -> println("yes")
        else -> println("no")
    }
}