package com.norbi930523.aoc2023.day3

data class EngineSymbol(
    val symbol: Char,
    val adjacentCoordinates: Set<Coordinate>
) {

    private val gearSymbol = '*'

    fun isGearSymbol(): Boolean {
        return symbol == gearSymbol
    }

}

class EngineSymbolFactory {

    fun createSymbol(symbol: Char, coordinate: Coordinate): EngineSymbol {
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
