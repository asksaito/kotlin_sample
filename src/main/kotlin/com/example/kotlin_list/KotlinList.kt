package com.example.kotlin_list

fun listExample() {
    val immutableList = listOf(1, 2, 3)
    val mutableList = mutableListOf(1, 2, 3)
    val arrayList = arrayListOf(1, 2, 3)

//    immutableList.add(4)    // NG(コンパイルエラー)
    mutableList.add(4)      // OK
    arrayList.add(4)        // OK

    val newImmutableList = immutableList.plus(5)    // OK
}