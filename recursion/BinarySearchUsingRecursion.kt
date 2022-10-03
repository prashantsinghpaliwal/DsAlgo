package com.byjusexamprep.kunalkushyt.recursion

fun main() {
    val arr = arrayOf(1,2,3,4,5)
    val target = 4
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