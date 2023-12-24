package com.norbi930523.aoc2023.day1

import com.norbi930523.aoc2023.io.TaskInputReader

fun main() {
    val values = TaskInputReader("/day1.txt")
        .readLines()
        .map { CalibrationValue.parse(it) }

    val calibrationValueCalculator = CalibrationValueCalculator(values)

    println(calibrationValueCalculator.sum())
}
