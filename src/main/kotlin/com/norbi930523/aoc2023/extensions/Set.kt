package com.norbi930523.aoc2023.extensions

fun <E> Set<E>.containsAny(collection: Collection<E>): Boolean {
    return collection.any(this::contains)
}
