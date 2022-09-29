package com.byjusexamprep.kunalkushyt.sorting


fun main() {
    val array = intArrayOf(10, -1, 0, 56, 12, 15, 11)
    println(selectionSort(array).contentToString())
}

fun selectionSort(array: IntArray): IntArray {
    // run i for n-1 times
    for (i in array.indices) {
        // find the max element in the remaining array and swap with correct index
        // last element will be filled everytime so subtracting with i below
        val last = array.size - 1 - i
        val maxIndex = getMaxIndex(array, 0, last)

        // swap max with last index
        swapTwoIndices(array, maxIndex, last)
    }
    return array
}

fun getMaxIndex(array: IntArray, startIndex: Int, lastIndex: Int): Int {
    var maxIndex = startIndex
    for (i in startIndex..lastIndex) {
        if (array[maxIndex] < array[i]) {
            maxIndex = i
        }
    }
    return maxIndex
}

fun swapTwoIndices(array: IntArray, first: Int, second: Int): IntArray {
    val temp = array[first]
    array[first] = array[second]
    array[second] = temp
    return array
}
