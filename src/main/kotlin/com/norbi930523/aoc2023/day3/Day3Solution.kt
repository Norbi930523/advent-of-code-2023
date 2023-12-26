package com.norbi930523.aoc2023.day3

import com.norbi930523.aoc2023.io.TaskInputReader

class Day3Solution(
    private val taskInputReader: TaskInputReader
) {

    fun run() {
        val engineSchematic = EngineSchematicInputParser.parse(taskInputReader.readLines().filter { it.isNotBlank() })

        val sumOfEnginePartNumbers = engineSchematic.partNumbers.sumOf { it.number }
        val sumOfEngineGearRatios = engineSchematic.gears.sumOf { it.ratio }

        println("Sum of engine part numbers: $sumOfEnginePartNumbers")
        println("Sum of engine gear ratios: $sumOfEngineGearRatios")
    }

}
