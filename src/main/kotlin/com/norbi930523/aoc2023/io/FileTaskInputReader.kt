package com.norbi930523.aoc2023.io

class FileTaskInputReader(
    private val filePath: String
): TaskInputReader {

    override fun readLines(): List<String> {
        return this::class.java.getResourceAsStream(filePath)?.bufferedReader()?.readLines() ?: listOf()
    }

}
