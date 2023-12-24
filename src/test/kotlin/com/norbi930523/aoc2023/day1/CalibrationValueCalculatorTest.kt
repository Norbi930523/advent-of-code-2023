package com.norbi930523.aoc2023.day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalibrationValueCalculatorTest {

    @Test
    fun test_when_using_sample_input_then_sum_gives_correct_result() {
        // Arrange
        val values = listOf(
            CalibrationValue(12),
            CalibrationValue(38),
            CalibrationValue(15),
            CalibrationValue(77)
        )

        // Act
        val calibrationValueCalculator = CalibrationValueCalculator(values)

        // Assert
        assertEquals(142, calibrationValueCalculator.sum())
    }

    @Test
    fun test_when_using_empty_input_then_sum_returns_zero() {
        // Act
        val calibrationValueCalculator = CalibrationValueCalculator(listOf())

        // Assert
        assertEquals(0, calibrationValueCalculator.sum())
    }
}
