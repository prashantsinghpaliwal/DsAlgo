package com.byjusexamprep.kunalkushyt.array_gfg

import com.byjusexamprep.kunalkushyt.sorting.swapTwoIndices


fun main() {
    val arr = intArrayOf(2, 0, 1)
    println(sortZerosOnesTwos(arr).contentToString())
}

private fun sortZerosOnesTwos(arr: IntArray): IntArray {
    // l, m and h represents 0, 1 and 2 respectively
    // STRATEGY =  we will put 0's and 1's to correct pos
    // and 1 will automatically come to its correct place

    var l = 0
    var m = 0
    var h = arr.size - 1
    var tempArray = arr
    while (m <= h) {
        if (arr[m] == 1) {
            // don't do anything as it will come to its place automatically
            m++
        } else if (arr[m] == 0) {
            // swap with current l, as it's the correct pos
            swapTwoIndices(arr, m, l)
            m++
            l++
        } else if (arr[m] == 2) {
            // swap with current h, as it's the correct pos
            swapTwoIndices(arr, m, h)
            h--
        }


    }

    return arr

}

