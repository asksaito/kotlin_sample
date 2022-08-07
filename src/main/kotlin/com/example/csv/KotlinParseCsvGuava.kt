package com.example.csv

import com.google.common.io.Files
import org.apache.commons.lang3.StringUtils
import java.io.File
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

fun readCsvAsList(filePath: String, doubleQuote: Boolean = false, encoding: Charset = StandardCharsets.UTF_8) {
    val enclosure = if (doubleQuote) "\"" else ""

    Files.asCharSource(File(filePath), encoding)
        .lines()
        .map { StringUtils.removeStart(StringUtils.removeEnd(it, enclosure), enclosure) }
        .map { it.split("$enclosure,$enclosure") }
        .forEach {
            // 1行ごとの処理
            println(it)
        }
}

fun readCsvAsMap(filePath: String, doubleQuote: Boolean = false, encoding: Charset = StandardCharsets.UTF_8) {
    val enclosure = if (doubleQuote) "\"" else ""
    val charSource = Files.asCharSource(File(filePath), encoding)

    // ヘッダ行
    val headers = charSource.readFirstLine()?.let {
        parseLine(it, enclosure)
    } ?: throw RuntimeException("Header is empty.")

    // データ行
    charSource.lines()
        .skip(1)
        .map { parseLine(it, enclosure) }
        .map { it.mapIndexed { index, column -> (headers[index] to column) }.toMap() }
        .forEach {
            // 1行ごとの処理
            println(it)
        }
}

private fun parseLine(line: String, enclosure: String): List<String> {
    return line
        .let { StringUtils.removeStart(line, enclosure) }
        .let { StringUtils.removeEnd(it, enclosure) }
        .let { it.split("$enclosure,$enclosure") }
}
