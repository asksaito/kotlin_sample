package com.example.sort

fun sortSample() {
    val list = listOf(5, null, 2, 4, 3, 1)

    val naturalOrder = list.sortedWith(nullsFirst())
    println(naturalOrder)

    val reverseOrder = list.sortedWith(nullsLast(reverseOrder()))
    println(reverseOrder)
}

fun sortSample2() {
    val list = listOf(
        Data(1, 5),
        Data(2, null),
        Data(3, 2),
        Data(4, 4),
        Data(5, null),
        Data(6, 3),
        Data(7, null),
        Data(8, 1)
    )

    val naturalOrder = list.sortedWith(compareBy(nullsFirst()) { it.order })
    println(naturalOrder)

    val reverseOrder = list.sortedWith(compareBy(nullsLast(reverseOrder())) { it.order })
    println(reverseOrder)
}

data class Data(val id: Int, val order: Int?)

