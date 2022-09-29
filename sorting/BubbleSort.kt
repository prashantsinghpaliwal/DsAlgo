package com.byjusexamprep.kunalkushyt.sorting

import java.util.*

fun main() {
    val array = intArrayOf(10, 16, 11, 20)
    println(bubbleSort(array).contentToString())
}

fun bubbleSort(array: IntArray): IntArray {
    // run i for n-1 times
    for (i in array.indices) {
        var isSwapped = false
        // for each step, max item will come at last respective index
        for (j in 1 until array.size - i) {
            // swap if item is smaller than previous item
            if (array[j] < array[j - 1]) {
                //swap
                val temp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = temp
                isSwapped = true
            }
        }

        // if we didn't swap for a particular value of i, it means array is sorted.
        // so close the program.
        if (!isSwapped){
            break
        }
    }

    return array
}