package com.norbi930523.aoc2023.day2

import com.norbi930523.aoc2023.io.TaskInputReader

class Day2Solution(
    private val taskInputReader: TaskInputReader,
    private val gameRules: CubeGameRules
) {

    fun run() {
        val games = taskInputReader
            .readLines()
            .filter { it.isNotBlank() }
            .map { CubeGame.parse(it) }

        var sumOfPossibleGameIds = 0L
        var sumOfPowerOfGames = 0L

        for (game in games) {
            if (gameRules.isGamePossible(game)) {
                sumOfPossibleGameIds += game.id
            }

            sumOfPowerOfGames += game.calculatePower()
        }

        println("Sum of possible game ids: $sumOfPossibleGameIds")
        println("Sum of power of games: $sumOfPowerOfGames")
    }

}
