package com.byjusexamprep.kunalkushyt.array_gfg

// Question Link - https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
// Concept is based on the fact that if(sum[x] == sum[y])
// then sum between all elements after x till y will be zero
// e.g. {15,-2,2,-8,1,7,10,23}
// here sum till 0th index is 15
// also sum till 5th index is 15
// it means all elements between these points have summation of 0

fun main() {
    val arr = arrayOf(15, -2, 2, -8, 1, 7, 10, 23)
    println(findLengthOfLargestSubArrayWithZeroSum(arr))
}


fun findLengthOfLargestSubArrayWithZeroSum(arr: Array<Int>): Int {
    var maxLength = 0
    val sumMap = mutableMapOf<Int, Int>()
    var totalSum = 0

    // for sum at 0th position
    sumMap[totalSum] = -1

    for (i in arr.indices) {
        totalSum += arr[i]

        if (sumMap.containsKey(totalSum)) {
            val length = i - sumMap[totalSum]!!
            if (length > maxLength) {
                maxLength = length
            }
        } else {
            sumMap[totalSum] = i
        }
    }

    return maxLength
}