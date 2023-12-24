package com.norbi930523.aoc2023.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CubeGamePowerTest {

    @Test
    fun test_when_one_minimum_required_color_is_zero_then_power_is_zero() {
        // Arrange
        val game = CubeGame(
            id = 1,
            cubeReveals = listOf(
                CubeReveal(red = 0, green = 2, blue = 3)
            )
        )

        // Act
        val actualPower = game.calculatePower()

        // Assert
        assertEquals(0, actualPower)
    }

    @Test
    fun test_when_all_minimum_required_color_is_above_zero_then_power_is_product_of_max_values() {
        // Arrange
        val game = CubeGame(
            id = 1,
            cubeReveals = listOf(
                CubeReveal(red = 2, green = 3, blue = 4)
            )
        )

        // Act
        val actualPower = game.calculatePower()

        // Assert
        assertEquals(24, actualPower)
    }

    @Test
    fun test_when_game_has_multiple_reveals_then_power_is_product_of_max_values() {
        // Arrange
        val game = CubeGame(
            id = 1,
            cubeReveals = listOf(
                CubeReveal(red = 2, green = 3, blue = 4),
                CubeReveal(red = 4, green = 1, blue = 2),
                CubeReveal(red = 2, green = 4, blue = 1)
            )
        )

        // Act
        val actualPower = game.calculatePower()

        // Assert
        assertEquals(64, actualPower)
    }
}
