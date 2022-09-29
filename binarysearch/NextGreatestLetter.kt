package com.byjusexamprep.kunalkushyt

fun main() {
    val arr = arrayOf('c','f','j', 'm', 'o', 'r')
    val target = 's'
    println(nextGreatestLetter(arr, target))
}

/*
 Next Greatest Letter
 e.g. letters = [c,f,j]
 and target = g
 so, the letter coming just after g in this array is j
 Hence O/P = j
*/

fun nextGreatestLetter(arr: Array<Char>, target: Char): Char {
    var start = 0
    var end = arr.size - 1


    while (start < end) {
        val mid = start + (end - start) / 2

        // for elements not existing in array, it will throw IndexOutOfBoundException
        // in case target element > last element in ascending order list and vice versa
//        if (mid >= arr.size -1)
//            return arr[0]

        if (target < arr[mid]) {
            end = mid - 1
        } else if (target > arr[mid]) {
            start = mid + 1
        }
    }

    if (start == arr.size)
        return arr[0]

    return arr[start]
}