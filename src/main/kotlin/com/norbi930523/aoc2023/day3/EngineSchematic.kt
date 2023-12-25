package com.norbi930523.aoc2023.day3

data class EngineSchematic(
    val partNumbers: Set<EnginePartNumber>,
    val gears: Set<EngineGear>,
    val symbols: Set<EngineSymbol>
) {

    companion object {

        private const val EMPTY_SYMBOL = '.'

        fun parse(lines: List<String>): EngineSchematic {
            val partNumbers: MutableSet<EnginePartNumber> = mutableSetOf()
            val symbols: MutableSet<EngineSymbol> = mutableSetOf()

            val partNumberBuilder = EnginePartNumberBuilder()
            val symbolFactory = EngineSymbolFactory()

            for (lineIndex in lines.indices) {
                val line = lines[lineIndex]

                for (columnIndex in line.indices) {
                    val character = line[columnIndex]

                    if (character.isDigit()) {
                        partNumberBuilder.appendDigit(
                            character,
                            Coordinate(x = columnIndex, y = lineIndex)
                        )
                    } else {
                        if (partNumberBuilder.isBuildInProgress()) {
                            partNumbers.add(partNumberBuilder.buildAndReset())
                        }

                        if (shouldConsiderSymbol(character)) {
                            symbols.add(symbolFactory.createSymbol(
                                character,
                                Coordinate(x = columnIndex, y = lineIndex)
                            ))
                        }
                    }
                }
            }

            val validEnginePartNumbers = getValidEnginePartNumbers(partNumbers = partNumbers, symbols = symbols)

            return EngineSchematic(
                partNumbers = validEnginePartNumbers,
                gears = getEngineGears(partNumbers = validEnginePartNumbers, symbols = symbols),
                symbols = symbols.toSet()
            )
        }

        private fun getEngineGears(partNumbers: Set<EnginePartNumber>, symbols: Set<EngineSymbol>): Set<EngineGear> {
            return symbols
                .asSequence()
                .filter { it.isGearSymbol() }
                .map { gearSymbol -> partNumbers.filter { it.intersectsCoordinates(gearSymbol.adjacentCoordinates) }.toSet() }
                .filter { it.size == 2 }
                .map { EngineGear(it.first(), it.last()) }
                .toSet()
        }

        private fun getValidEnginePartNumbers(partNumbers: Set<EnginePartNumber>, symbols: Set<EngineSymbol>): Set<EnginePartNumber> {
            val allSymbolCoordinates = symbols.flatMap { it.adjacentCoordinates }.toSet()

            return partNumbers.filter { it.intersectsCoordinates(allSymbolCoordinates) }.toSet()
        }

        private fun shouldConsiderSymbol(character: Char): Boolean {
            return character != EMPTY_SYMBOL
        }

    }

}
