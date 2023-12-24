package com.norbi930523.aoc2023.day2

data class CubeGameRules(
    val maxRed: Int,
    val maxGreen: Int,
    val maxBlue: Int
) {

    init {
        require(maxRed >= 0) { "Max number of reds must be non-negative: $maxRed" }
        require(maxGreen >= 0) { "Max number of greens must be non-negative: $maxGreen" }
        require(maxBlue >= 0) { "Max number of blues must be non-negative: $maxBlue" }
    }

    fun isGamePossible(game: CubeGame): Boolean {
        return game.cubeReveals.all { isRevealPossible(it) }
    }

    private fun isRevealPossible(cubeReveal: CubeReveal): Boolean {
        return cubeReveal.red <= maxRed && cubeReveal.green <= maxGreen && cubeReveal.blue <= maxBlue
    }

}
