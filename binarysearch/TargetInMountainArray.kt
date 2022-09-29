package com.byjusexamprep.kunalkushyt



fun main() {
    val arr = arrayOf(2, 3, 4, 7, 9, 11, 12, 15, 23, 30, 31, 34, 35, 36)
    val target = 35
    val peak = findPeak(arr)
    val searchInAsc = orderAgnosticBinarySearch(arr, target, 0, peak)
    val index = if (searchInAsc != -1) searchInAsc
    else orderAgnosticBinarySearch(arr, target, peak + 1, arr.size)
    println("index is $index")
}

fun orderAgnosticBinarySearch(
    arr: Array<Int>,
    target: Int,
    s: Int,
    e: Int
): Int {

    var start = s
    var end = e

    val ifAscending = arr[start] < arr[end]

    while (start <= end) {
        val mid = start + (end - start) / 2

        if (ifAscending) {
            if (target < arr[mid]) {
                end = mid - 1
            } else if (target > arr[mid]) {
                start = mid + 1
            } else {
                return mid
            }
        } else {
            if (target < arr[mid]) {
                start = mid + 1
            } else if (target > arr[mid]) {
                end = mid - 1
            } else {
                return mid
            }
        }
    }
    return -1
}