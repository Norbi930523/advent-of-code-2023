package com.norbi930523.aoc2023.day2

import com.norbi930523.aoc2023.extensions.COMMA

data class CubeReveal(
    val red: Long,
    val green: Long,
    val blue: Long
) {

    init {
        require(red >= 0) { "Number of reds must be non-negative: $red" }
        require(green >= 0) { "Number of greens must be non-negative: $green" }
        require(blue >= 0) { "Number of blues must be non-negative: $blue" }
    }

    companion object {

        private const val RED_SUFFIX = "red"
        private const val GREEN_SUFFIX = "green"
        private const val BLUE_SUFFIX = "blue"

        fun parse(value: String): CubeReveal {
            val colours = value.split(String.COMMA).filter { it.isNotBlank() }.map { it.lowercase().trim() }

            require(colours.isNotEmpty()) { "At least one colour required: $value" }

            return CubeReveal(
                red = parseColourCount(colours, RED_SUFFIX),
                green = parseColourCount(colours, GREEN_SUFFIX),
                blue = parseColourCount(colours, BLUE_SUFFIX)
            )
        }

        private fun parseColourCount(colours: List<String>, suffix: String): Long {
            return colours.firstOrNull { it.endsWith(suffix) }?.removeSuffix(suffix)?.trim()?.toLong() ?: 0
        }

    }

}
