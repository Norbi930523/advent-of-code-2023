package com.norbi930523.aoc2023

import com.norbi930523.aoc2023.day1.Day1Solution
import com.norbi930523.aoc2023.day2.CubeGameRules
import com.norbi930523.aoc2023.day2.Day2Solution
import com.norbi930523.aoc2023.io.FileTaskInputReader

fun main() {
    Solution.runDay1Solution()
    Solution.runDay2Solution()
}

private object Solution {

    private const val SEPARATOR = "----------"

    fun runDay1Solution() {
        println("Day 1 solution:")

        Day1Solution(FileTaskInputReader("/day1.txt")).run()

        println(SEPARATOR)
    }

    fun runDay2Solution() {
        println("Day 2 solution:")

        val gameRules = CubeGameRules(
            maxRed = 12,
            maxGreen = 13,
            maxBlue = 14
        )

        Day2Solution(FileTaskInputReader("/day2.txt"), gameRules).run()

        println(SEPARATOR)
    }

}
