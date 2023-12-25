package com.norbi930523.aoc2023.day3

import com.norbi930523.aoc2023.extensions.containsAny

data class EnginePartNumber(
    val number: Long,
    val coordinates: Set<Coordinate>
) {

    fun intersectsCoordinates(coordinates: Set<Coordinate>): Boolean {
        return coordinates.containsAny(this.coordinates)
    }

}

class EnginePartNumberBuilder(
    private var number: StringBuilder = StringBuilder(),
    private var coordinates: MutableSet<Coordinate> = mutableSetOf()
) {

    fun appendDigit(digit: Char, coordinate: Coordinate) {
        number.append(digit)
        coordinates.add(coordinate)
    }

    fun buildAndReset(): EnginePartNumber {
        val partNumber = EnginePartNumber(
            number = number.toString().toLong(),
            coordinates = coordinates.toSet()
        )

        number.clear()
        coordinates.clear()

        return partNumber
    }

    fun isBuildInProgress(): Boolean {
        return number.isNotEmpty()
    }

}
