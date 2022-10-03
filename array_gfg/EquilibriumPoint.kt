package com.byjusexamprep.kunalkushyt.array_gfg


// Question Link - https://leetcode.com/problems/find-pivot-index/
// Works on logic below
// if(leftSum == rightSum) return index
// leftSum = sum[i] - arr[i]
// and rightSum = totalSum - sum[i]
// Time complexity - O(n)

fun main() {
    val arr = arrayOf(1,0)
    println(findEquilibriumPoint(arr))
}

fun findEquilibriumPoint(arr: Array<Int>): Int {

    if (arr.size == 1)
        return arr[0]

    if (arr.size == 2)
        return -1


    // find sum array
    val sumArray = IntArray(arr.size)
    var totalSum = 0
    for (i in arr.indices) {
        totalSum += arr[i]
        sumArray[i] = totalSum
    }

    for (i in arr.indices) {
        val leftSum = sumArray[i] - arr[i]
        val rightSum = totalSum - sumArray[i]
        if (leftSum == rightSum)
            return i
    }

    return -1
}