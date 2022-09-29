package com.byjusexamprep.kunalkushyt.recursion

fun main() {
    val arr = arrayOf(2, 12, 21, 23, 33, 37, 38, 40, 41)
    val target = 12
    val start = 0
    val end = arr.size - 1
    println(recursionBinarySearch(arr, start, end, target))
}

fun recursionBinarySearch(arr: Array<Int>, start: Int, end: Int, target: Int): Int {

    if (target < arr[start] || target > arr[end]) {
        return -1
    }

    if (start > end) {
        return -1
    }

    val mid = start + (end - start) / 2
    if (arr[mid] == target) {
        return mid
    }

    return if (target < arr[mid])
        recursionBinarySearch(arr, start, mid - 1, target)
    else recursionBinarySearch(arr, mid + 1, end, target)
}