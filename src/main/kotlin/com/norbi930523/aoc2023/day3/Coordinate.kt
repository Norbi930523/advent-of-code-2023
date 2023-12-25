package com.norbi930523.aoc2023.day3

data class Coordinate(
    val x: Long,
    val y: Long
) {

    constructor(x: Int, y: Int): this(x = x.toLong(), y = y.toLong())

    fun left(): Coordinate {
        return Coordinate(
            x = x,
            y = y - 1
        )
    }

    fun right(): Coordinate {
        return Coordinate(
            x = x,
            y = y + 1
        )
    }

    fun up(): Coordinate {
        return Coordinate(
            x = x + 1,
            y = y
        )
    }

    fun down(): Coordinate {
        return Coordinate(
            x = x - 1,
            y = y
        )
    }

}
