package com.norbi930523.aoc2023.day1

internal data class CalibrationValue(
    val value: Int
) {

    init {
        require(value >= 0) { "Value must be non-negative: $value" }
    }

    companion object {

        private val WORDS_TO_DIGITS = mapOf(
            Pair("one", 1),
            Pair("two", 2),
            Pair("three", 3),
            Pair("four", 4),
            Pair("five", 5),
            Pair("six", 6),
            Pair("seven", 7),
            Pair("eight", 8),
            Pair("nine", 9)
        )

        fun parse(value: String): CalibrationValue {
            val digits = parseDigits(value)

            if (digits.isEmpty()) {
                return CalibrationValue(0)
            }

            val calibrationValue = (digits.first() * 10) + digits.last()

            return CalibrationValue(calibrationValue)
        }

        private fun parseDigits(value: String): List<Int> {
            val digits: MutableList<Int> = mutableListOf()

            for (i in value.indices) {
                if (value[i].isDigit()) {
                    digits.add(value[i].digitToInt())
                } else {
                    val substring = value.substring(i)

                    WORDS_TO_DIGITS
                        .filterKeys { substring.startsWith(it) }
                        .values
                        .firstOrNull()
                        ?.also { digits.add(it) }
                }
            }

            return digits.toList()
        }

    }
}
