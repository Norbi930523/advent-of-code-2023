package com.norbi930523.aoc2023.day4

import com.norbi930523.aoc2023.extensions.COLON
import java.util.regex.Pattern

object ScratchcardInputParser {

    private const val CARD_PREFIX = "card"

    private val SPACE_CHARS_PATTERN = Pattern.compile(" +")

    fun parse(lines: List<String>): List<Scratchcard> {
        return lines.map(this::parseLine).toList()
    }

    private fun parseLine(line: String): Scratchcard {
        val cardAndNumbers = line.split(String.COLON)
        val winningNumbersAndOwnNumbers = cardAndNumbers.last().split("|")

        return Scratchcard(
            id = parseCardId(cardAndNumbers.first()),
            winningNumbers = parseNumbers(winningNumbersAndOwnNumbers.first()),
            ownNumbers = parseNumbers(winningNumbersAndOwnNumbers.last())
        )
    }

    private fun parseNumbers(numbers: String): Set<Long> {
        return numbers
            .trim()
            .split(SPACE_CHARS_PATTERN)
            .map { it.toLong() }
            .toSet()
    }

    private fun parseCardId(card: String): Long {
        return card.lowercase().removePrefix(CARD_PREFIX).trim().toLong()
    }

}
