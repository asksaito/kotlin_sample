package com.example.csv

import org.apache.commons.io.input.BOMInputStream
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths


fun bomCsvParse(filePath: String) {
//    BufferedReader(InputStreamReader(BOMInputStream(FileInputStream(filePath)), StandardCharsets.UTF_8)).use { br ->
//        var line: String?
//        while (br.readLine().also { line = it } != null) {
//            println(line)
//        }
//    }

    Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8).use { br ->
        var line: String?
        while (br.readLine().also { line = it } != null) {
            println(line)
        }
    }
}
