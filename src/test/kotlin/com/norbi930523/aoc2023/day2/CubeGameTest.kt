package com.norbi930523.aoc2023.day2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*

class CubeGameTest {

    @Test
    fun test_when_game_string_has_no_colon_then_parsing_throws_exception() {
        // Arrange
        val input = "Game 1 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"

        // Assert
        assertThrows<IllegalArgumentException> { CubeGame.parse(input) }
    }

    @Test
    fun test_when_game_string_has_non_positive_id_then_parsing_throws_exception() {
        // Arrange
        val input = "Game 0: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"

        // Assert
        assertThrows<IllegalArgumentException> { CubeGame.parse(input) }
    }

    @Test
    fun test_when_game_string_has_extra_whitespaces_then_game_is_parsed_correctly() {
        // Arrange
        val input = " Game 1 : 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"

        // Act
        val game = CubeGame.parse(input)

        // Assert
        assertEquals(1L, game.id)
        assertEquals(3, game.cubeReveals.size)
    }

    @Test
    fun test_when_game_string_has_one_reveal_then_game_is_created_with_one_reveal() {
        // Arrange
        val input = "Game 1: 3 blue, 4 red, 2 green"

        // Act
        val game = CubeGame.parse(input)

        // Assert
        assertEquals(1L, game.id)
        assertEquals(1, game.cubeReveals.size)
    }

    @Test
    fun test_when_game_string_has_more_than_one_reveal_then_game_is_created_with_the_same_amount_of_reveals() {
        // Arrange
        val input = "Game 2: 3 blue, 4 red, 2 green; 2 red, 1 green, 4 blue"

        // Act
        val game = CubeGame.parse(input)

        // Assert
        assertEquals(2L, game.id)
        assertEquals(2, game.cubeReveals.size)
    }
}
