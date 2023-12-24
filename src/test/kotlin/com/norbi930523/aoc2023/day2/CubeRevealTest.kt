package com.norbi930523.aoc2023.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CubeRevealTest {

    @Test
    fun test_when_parsing_empty_string_then_parsing_throws_exception() {
        // Arrange
        val input = ""

        // Assert
        assertThrows<IllegalArgumentException> { CubeReveal.parse(input) }
    }

    @Test
    fun test_when_parsing_blank_string_then_parsing_throws_exception() {
        // Arrange
        val input = "  "

        // Assert
        assertThrows<IllegalArgumentException> { CubeReveal.parse(input) }
    }

    @Test
    fun test_when_two_colours_are_missing_from_string_then_missing_colours_default_to_zero() {
        // Arrange
        val input = "2 green"

        // Act
        val cubeReveal = CubeReveal.parse(input)

        // Assert
        assertEquals(2, cubeReveal.green)
        assertEquals(0, cubeReveal.red)
        assertEquals(0, cubeReveal.blue)
    }

    @Test
    fun test_when_one_colour_is_missing_from_string_then_missing_colour_defaults_to_zero() {
        // Arrange
        val input = "2 red, 3 blue"

        // Act
        val cubeReveal = CubeReveal.parse(input)

        // Assert
        assertEquals(0, cubeReveal.green)
        assertEquals(2, cubeReveal.red)
        assertEquals(3, cubeReveal.blue)
    }

    @Test
    fun test_when_all_colours_are_present_in_string_then_all_colours_are_parsed() {
        // Arrange
        val input = "2 red, 3 blue, 4 green"

        // Act
        val cubeReveal = CubeReveal.parse(input)

        // Assert
        assertEquals(4, cubeReveal.green)
        assertEquals(2, cubeReveal.red)
        assertEquals(3, cubeReveal.blue)
    }

    @Test
    fun test_when_string_has_extra_whitespaces_then_all_colours_are_parsed() {
        // Arrange
        val input = " 2  red , 3  blue , 4  green "

        // Act
        val cubeReveal = CubeReveal.parse(input)

        // Assert
        assertEquals(4, cubeReveal.green)
        assertEquals(2, cubeReveal.red)
        assertEquals(3, cubeReveal.blue)
    }

}
