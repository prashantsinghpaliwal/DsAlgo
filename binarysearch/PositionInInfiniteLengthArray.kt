package com.byjusexamprep.kunalkushyt

// Question Link - https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

fun main() {
    val arr = IntArray(8)
    initArr(arr)
    val target = 36
    println(findRange(arr, target))
}

/*  This method finds the range or window
    in which target exists. After finding
    the range we can easily apply binary
    search to find the element's index.
*/
fun findRange(arr: IntArray, target: Int): Int {
    var start = 0
    var end = 1

    while (target > arr[end]) {
        val newStart = end + 1
        // double the box value
        // end = prev end + sizeOfBox*2
        end = end + (end - start + 1) * 2
        start = newStart
    }

    if (target == arr[end])
        return end

    return normalBinarySearch(arr, target, start, end)
}

fun normalBinarySearch(
    arr: IntArray,
    target: Int,
    s: Int,
    e: Int
): Int {
    var start = s
    var end = e
    while (start <= end) {
        val mid = start + (end - start) / 2

        if (target < arr[mid]) {
            end = mid - 1
        } else if (target > arr[mid]) {
            start = mid + 1
        } else {
            return mid
        }
    }
    return -1
}