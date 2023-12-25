package com.norbi930523.aoc2023.day2

import com.norbi930523.aoc2023.io.TaskInputReader

class Day2Solution {

    fun run() {
        val gameRules = CubeGameRules(
            maxRed = 12,
            maxGreen = 13,
            maxBlue = 14
        )

        val games = TaskInputReader("/day2.txt")
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
