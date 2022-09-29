package com.byjusexamprep.kunalkushyt

fun main() {
    val arr = IntArray(3)
    initArr(arr)
    val pivot = findPivot(arr)

    // elements till pivot will be pivot + 1, as index start from 0
    val rotationCount = pivot + 1
    println("count is $rotationCount")
}

