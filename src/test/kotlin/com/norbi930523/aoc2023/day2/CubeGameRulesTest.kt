package com.norbi930523.aoc2023.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CubeGameRulesTest {

    private val testRules = CubeGameRules(
        maxRed = 10,
        maxGreen = 20,
        maxBlue = 30
    )

    @Test
    fun test_when_all_reveals_are_possible_then_game_is_possible() {
        // Arrange
        val game = CubeGame(
            id = 1,
            cubeReveals = listOf(
                CubeReveal(red = 1, green = 2, blue = 3),
                CubeReveal(red = 3, green = 2, blue = 1),
                CubeReveal(red = 1, green = 1, blue = 1)
            )
        )

        // Assert
        assertTrue(testRules.isGamePossible(game))
    }

    @Test
    fun test_when_one_reveal_is_not_possible_then_game_is_not_possible() {
        // Arrange
        val game = CubeGame(
            id = 1,
            cubeReveals = listOf(
                CubeReveal(red = 1, green = 2, blue = 3),
                CubeReveal(red = 100, green = 2, blue = 1),
                CubeReveal(red = 1, green = 1, blue = 1)
            )
        )

        // Assert
        assertFalse(testRules.isGamePossible(game))
    }

    @Test
    fun test_when_no_reveal_is_possible_then_game_is_not_possible() {
        // Arrange
        val game = CubeGame(
            id = 1,
            cubeReveals = listOf(
                CubeReveal(red = 1, green = 200, blue = 3),
                CubeReveal(red = 100, green = 2, blue = 1),
                CubeReveal(red = 1, green = 1, blue = 300)
            )
        )

        // Assert
        assertFalse(testRules.isGamePossible(game))
    }

    @Test
    fun test_when_multiple_counts_are_over_the_limit_then_game_is_not_possible() {
        // Arrange
        val game = CubeGame(
            id = 1,
            cubeReveals = listOf(
                CubeReveal(red = 200, green = 200, blue = 3)
            )
        )

        // Assert
        assertFalse(testRules.isGamePossible(game))
    }

    @Test
    fun test_when_all_counts_are_over_the_limit_then_game_is_not_possible() {
        // Arrange
        val game = CubeGame(
            id = 1,
            cubeReveals = listOf(
                CubeReveal(red = 200, green = 100, blue = 300)
            )
        )

        // Assert
        assertFalse(testRules.isGamePossible(game))
    }
}
