package com.norbi930523.aoc2023.day2

import com.norbi930523.aoc2023.extensions.COLON
import com.norbi930523.aoc2023.extensions.SEMICOLON

data class CubeGame(
    val id: Long,
    val cubeReveals: List<CubeReveal>
) {

    init {
        require(id > 0) { "Game id must be positive: $id" }
        require(cubeReveals.isNotEmpty()) { "At least one reveal is required" }
    }

    fun calculatePower(): Long {
        var minRed = 0L
        var minGreen = 0L
        var minBlue = 0L

        cubeReveals.forEach {
            minRed = minRed.coerceAtLeast(it.red)
            minGreen = minGreen.coerceAtLeast(it.green)
            minBlue = minBlue.coerceAtLeast(it.blue)
        }

        return minRed * minGreen * minBlue
    }

    companion object {

        private const val GAME_ID_PREFIX = "game"

        fun parse(value: String): CubeGame {
            val gameAndReveals = value.split(String.COLON)

            require(gameAndReveals.size == 2) { "Invalid game data: $value" }

            return CubeGame(
                id = parseGameId(gameAndReveals.first()),
                cubeReveals = gameAndReveals.last().split(String.SEMICOLON).map { CubeReveal.parse(it) }
            )
        }

        private fun parseGameId(value: String): Long {
            return value.trim().lowercase().removePrefix(GAME_ID_PREFIX).trim().toLong()
        }

    }

}
