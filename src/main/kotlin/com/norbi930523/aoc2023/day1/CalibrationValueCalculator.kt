package com.norbi930523.aoc2023.day1

internal class CalibrationValueCalculator(
    private val values: List<CalibrationValue>
) {
    fun sum() = values.sumOf { it.value }
}
