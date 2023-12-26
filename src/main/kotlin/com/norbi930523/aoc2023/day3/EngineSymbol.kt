package com.norbi930523.aoc2023.day3

private const val GEAR_SYMBOL = '*'

data class EngineSymbol(
    val symbol: Char,
    val adjacentCoordinates: Set<Coordinate>
) {

    fun isGearSymbol(): Boolean {
        return symbol == GEAR_SYMBOL
    }

    companion object {

        fun from(symbol: Char, coordinate: Coordinate): EngineSymbol {
            return EngineSymbol(
                symbol = symbol,
                adjacentCoordinates = setOf(
                    coordinate.right(),
                    coordinate.right().down(),
                    coordinate.down(),
                    coordinate.down().left(),
                    coordinate.left(),
                    coordinate.left().up(),
                    coordinate.up(),
                    coordinate.up().right()
                )
            )
        }

    }
}
