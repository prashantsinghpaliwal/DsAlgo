package com.byjusexamprep.kunalkushyt.array_gfg

// check pepcoding for solution
fun main() {
    val arr = arrayOf(1, 1, 1)
    val k = 2
    println(findNumberOfSubArraysWithSumK(arr, k))
}

private fun findNumberOfSubArraysWithSumK(arr: Array<Int>, k: Int): Int {
    var count = 0
    val map = mutableMapOf<Int, Int>()
    map[0] = 1
    var sum = 0
    for (i in arr.indices){
        sum += arr[i]
        if (map.contains(sum  - k)){
            count += map[sum - k] ?: 0
        }

        // incrementing sum's existence if found earlier else setting to 1 for first time occurence
        val sumExistCount = map[sum] ?: 0
        map[sum] = sumExistCount + 1
    }

    return count

}