package com.byjusexamprep.kunalkushyt.sorting


fun main() {
    val array = intArrayOf(10, -1, 0, 56, 12, 15, 11)
    println(insertionSort(array).contentToString())
}

fun insertionSort(array: IntArray): IntArray {
    // run i for n-2 times
    for (i in 0..array.size - 2) {
        for (j in i + 1 downTo 1) {
            if (array[j] < array[j - 1]) {
                swapTwoIndices(array, j, j - 1)
            } else {
                // coz it doesn't make sense to check the already sorted left side
                break
            }
        }
    }

    return array
}