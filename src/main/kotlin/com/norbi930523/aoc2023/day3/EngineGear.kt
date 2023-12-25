package com.norbi930523.aoc2023.day3

data class EngineGear(
    val partNumber1: EnginePartNumber,
    val partNumber2: EnginePartNumber
) {

    val ratio: Long
        get() = partNumber1.number * partNumber2.number

}
