package com.example.map_vs_flatmap

import java.util.stream.Collectors

class MapVsFlatMap {
    fun example() {
        val list = listOf(1, 2, 3)

        val convertedByMap = list
            .map { listOf(it, it) }
        println(convertedByMap)
        // [[1, 1], [2, 2], [3, 3]]

        val convertedByMapFlatten = list
            .map { listOf(it, it) }
            .flatten()
        println(convertedByMapFlatten)
        // [1, 1, 2, 2, 3, 3]

        val convertedByFlatMap = list
            .flatMap { listOf(it, it) }
        println(convertedByFlatMap)
        // [1, 1, 2, 2, 3, 3]

        val convertedByStreamMap = list
            .stream()
            .map { listOf(it, it) }
            .collect(Collectors.toList())
        println(convertedByStreamMap)

        val convertedByStream = list
            .stream()
            .flatMap { listOf(it, it).stream() }
            .collect(Collectors.toList())
        println(convertedByStream)
    }

    fun example2() {
        val queryList = listOf("Java", "Kotlin", "駆け出しエンジニア")

        val convertedByFlatMap = queryList
            .flatMap { callTwitterApi(it) }
        println(convertedByFlatMap)
        // [1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 7, 8, 9]

//        val convertedByFlatMap2 = queryList
//            .flatMap { callTwitterApi(it) }
//            .distinct()
//            .sortedDescending()
//            .take(5)
//        println(convertedByFlatMap2)
//        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    fun example3() {
        val queryList = listOf("Java", "Kotlin", "駆け出しエンジニア")

        val resultList = mutableListOf<Long>()
        for (query in queryList) {
            val ids = callTwitterApi(query)
            resultList.addAll(ids)
        }
        println(resultList)
        // [1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    private fun callTwitterApi(query: String): List<Long> {
        // Query文字列で検索すると、Queryを含むツイートのIDを返すAPIを呼ぶと仮定する
        // APIのレスポンスのつもり↓
        return LongRange(1, query.length.toLong()).toList()
    }
}