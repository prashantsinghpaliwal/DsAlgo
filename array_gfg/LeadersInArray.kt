package com.byjusexamprep.kunalkushyt.array_gfg


// An element of array is leader if it is greater than
// or equal to all the elements to its right side.
// The rightmost element is always a leader.

// Question Link - https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

fun main() {
    val arr = arrayOf(16,17,4,3,5,2)
    println(findLeadersInArray(arr))
}

fun findLeadersInArray(arr: Array<Int>): MutableList<Int> {
    val leaderList = mutableListOf<Int>()

    // since last element is always leader, adding it to list
    var maxElement = arr[arr.size - 1]
    leaderList.add(maxElement)
    for (i in arr.size - 1 downTo 0) {
        if (arr[i] > maxElement){
            maxElement = arr[i]
            leaderList.add(maxElement)
        }
    }
    return reverseArr(leaderList)
}

fun reverseArr(arr: MutableList<Int>): MutableList<Int> {
    var fIndex = 0
    var lIndex = arr.size - 1
    while (fIndex < lIndex) {
        val temp = arr[fIndex]
        arr[fIndex] = arr[lIndex]
        arr[lIndex] = temp
        fIndex++
        lIndex--
    }
    return arr
}