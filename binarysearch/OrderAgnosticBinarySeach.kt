package com.byjusexamprep.kunalkushyt


fun main() {
    val arr = arrayOf(2, 3, 4, 7, 9, 11, 12, 15, 23, 30, 31, 34, 35, 36)
    val target = 35
    val reversedArray = arr.reversedArray()
    println("reversedArray is $reversedArray")
    println(orderAgnosticBinarySearch(arr, target))
}

fun orderAgnosticBinarySearch(
    arr: Array<Int>,
    target: Int
): Int {

    var start = 0
    var end = arr.size - 1

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