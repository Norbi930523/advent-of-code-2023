package com.norbi930523.aoc2023.io

class TaskInputReader(
    private val filePath: String
) {

    fun readLines(): List<String> {
        return this::class.java.getResourceAsStream(filePath)?.bufferedReader()?.readLines() ?: listOf()
    }

}
