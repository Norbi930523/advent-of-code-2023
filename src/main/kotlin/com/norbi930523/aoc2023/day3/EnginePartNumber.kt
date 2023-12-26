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

