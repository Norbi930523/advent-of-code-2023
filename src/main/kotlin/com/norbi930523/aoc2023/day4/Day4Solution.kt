package com.norbi930523.aoc2023.day4

import com.norbi930523.aoc2023.io.TaskInputReader
import kotlin.math.min

class Day4Solution(
    private val taskInputReader: TaskInputReader
) {

    fun run() {
        val lines = taskInputReader.readLines().filter { it.isNotEmpty() }
        val scratchcards = ScratchcardInputParser.parse(lines)

        val sumOfWinningCardWorth = scratchcards.filter { it.hasWinningNumbers() }.sumOf { it.worth }
        val totalCountOfCards = scratchcards.size + getTotalCountOfCopies(scratchcards)

        println("Sum of winning card worth: $sumOfWinningCardWorth")
        println("Total count of cards: $totalCountOfCards")
    }

    private fun getTotalCountOfCopies(scratchcards: List<Scratchcard>): Int {
        val countOfCopiesByCardId = mutableMapOf<Long, Int>()

        for (index in scratchcards.indices) {
            val scratchcard = scratchcards[index]
            val nextIndex = index + 1

            if (scratchcard.hasNoWinningNumbers() || nextIndex > scratchcards.lastIndex) {
                continue
            }

            val winnerCopies = scratchcards.subList(
                nextIndex,
                min(scratchcards.size, nextIndex + scratchcard.countOfWinners)
            )

            val countOfCopiesOfThisCard = countOfCopiesByCardId.getOrDefault(scratchcard.id, 0)

            for (winnerCopy in winnerCopies) {
                countOfCopiesByCardId.compute(winnerCopy.id) { _, value -> (value ?: 0) + countOfCopiesOfThisCard + 1 }
            }
        }

        return countOfCopiesByCardId.values.sum()
    }

}
