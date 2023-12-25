package com.norbi930523.aoc2023.day1

import com.norbi930523.aoc2023.io.TaskInputReader

class Day1Solution(
    private val taskInputReader: TaskInputReader
) {

    fun run() {
        val values = taskInputReader
            .readLines()
            .map { CalibrationValue.parse(it) }

        val calibrationValueCalculator = CalibrationValueCalculator(values)

        println(calibrationValueCalculator.sum())
    }

}
