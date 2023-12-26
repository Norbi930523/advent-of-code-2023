package com.norbi930523.aoc2023.day4

import com.norbi930523.aoc2023.extensions.containsAny
import kotlin.math.pow

data class Scratchcard(
    val id: Long,
    val winningNumbers: Set<Long>,
    val ownNumbers: Set<Long>
) {

    val countOfWinners: Int
        get() = ownNumbers.count { winningNumbers.contains(it) }

    val worth: Long
        get() = 2.0.pow(countOfWinners - 1).toLong()

    fun hasWinningNumbers(): Boolean {
        return winningNumbers.containsAny(ownNumbers)
    }

    fun hasNoWinningNumbers() = !hasWinningNumbers()

}
