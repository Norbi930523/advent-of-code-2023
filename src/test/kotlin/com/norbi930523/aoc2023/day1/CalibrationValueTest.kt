package com.norbi930523.aoc2023.day1

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class CalibrationValueTest {

    @Test
    fun test_when_creating_with_negative_value_then_exception_is_thrown() {
        assertThrows<IllegalArgumentException> { CalibrationValue(-1) }
    }

    @Test
    fun test_when_string_contains_multiple_digits_then_value_consists_of_first_and_last_digit() {
        // Arrange
        val input = "1a2b3c"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(13, calibrationValue.value)
    }

    @Test
    fun test_when_string_contains_one_digit_then_value_consists_of_the_same_digit_twice() {
        // Arrange
        val input = "ab1cd"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(11, calibrationValue.value)
    }

    @Test
    fun test_when_string_starts_and_ends_with_digits_then_value_consists_of_first_and_last_digit() {
        // Arrange
        val input = "1a2b3c4"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(14, calibrationValue.value)
    }

    @Test
    fun test_when_string_starts_and_ends_with_non_digits_then_value_consists_of_first_and_last_digit() {
        // Arrange
        val input = "a1b2c3d4e"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(14, calibrationValue.value)
    }

    @Test
    fun test_when_string_consists_of_exactly_one_digit_then_value_consists_of_the_same_digit_twice() {
        // Arrange
        val input = "1"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(11, calibrationValue.value)
    }

    @Test
    fun test_when_string_consists_of_exactly_two_digits_then_value_consists_of_first_and_last_digit() {
        // Arrange
        val input = "12"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(12, calibrationValue.value)
    }

    @Test
    fun test_when_string_consists_of_more_than_two_digits_then_value_consists_of_first_and_last_digit() {
        // Arrange
        val input = "123"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(13, calibrationValue.value)
    }

    @Test
    fun test_when_string_contains_no_digits_then_value_is_zero() {
        // Arrange
        val input = "abc"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(0, calibrationValue.value)
    }

    @Test
    fun test_when_string_is_empty_then_value_is_zero() {
        // Arrange
        val input = ""

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(0, calibrationValue.value)
    }

    @Test
    fun test_when_string_contains_digits_as_words_then_value_consists_of_digit_of_first_and_last_word() {
        // Arrange
        val input = "fooonebartwothree"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(13, calibrationValue.value)
    }

    @Test
    fun test_when_string_consists_of_digits_as_words_and_digits_then_value_consists_of_digit_of_first_and_last_word() {
        // Arrange
        val input = "onefootwobar3"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(13, calibrationValue.value)
    }

    @Test
    fun test_when_string_contains_overlapping_words_then_value_consists_of_digit_of_first_and_last_word() {
        // Arrange
        val input = "4oneight"

        // Act
        val calibrationValue = CalibrationValue.parse(input)

        // Assert
        assertEquals(48, calibrationValue.value)
    }
}
