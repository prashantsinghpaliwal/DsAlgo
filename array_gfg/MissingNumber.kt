package com.byjusexamprep.kunalkushyt.array_gfg

fun main() {
    val arr = arrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)
    println(findSingleMissingNumberWithXOR(arr))
}

private fun findMissingNumberBruteForce(arr: Array<Int>): Int {
    val missingNumber = 0
    for (i in 0..arr.size + 1) {
        if (!arr.contains(i)) return i
    }

    return missingNumber
}

private fun findSingleMissingNumber(arr: Array<Int>): Int {
    // originalArraySize = currentSize + 1 since one number is missing
    val originalArraySize = arr.size
    val originalSum = (originalArraySize * (originalArraySize + 1)) / 2
    var currentSum = 0
//    for (i in arr.indices) {
//        currentSum += arr[i]
//    }
// for each performing better on leetcode somehow
    arr.forEach { number ->
        currentSum += number
    }

    return originalSum - currentSum
}

private fun findSingleMissingNumberWithXOR(arr: Array<Int>): Int {
    val mainArr  = IntArray(arr.size + 1) { i -> i }

    var xor_arr = 0
    for (element in arr) {
        xor_arr = xor_arr xor element
    }

    var mainArrayXor = 0
    for (element in mainArr) {
        mainArrayXor = mainArrayXor xor element
    }

    return mainArrayXor xor xor_arr

}