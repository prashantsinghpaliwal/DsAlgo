package com.byjusexamprep.kunalkushyt

fun main() {
    val arr = IntArray(3)
    initArr(arr)
    val target = 3
    val pivot = findPivot(arr)
    if (pivot == -1) {
        val index = normalBinarySearch(arr, target, 0, arr.size - 1)
        println("$target found at position $index")
    } else {
        val firstHalfSearch = normalBinarySearch(arr, target, 0, pivot)
        val targetIndex = if (firstHalfSearch != -1) firstHalfSearch else normalBinarySearch(
            arr,
            target,
            pivot + 1,
            arr.size - 1
        )
        println("$target found at position $targetIndex")
    }

}

fun initArr(arr: IntArray) {
    arr[0] = 3
    arr[1] = 5
    arr[2] = 1
}

fun findPivotWithDuplicates(
    arr: IntArray
): Int {
    var start = 0
    var end = arr.size - 1
    while (start <= end) {
        val mid = start + (end - start) / 2

        if (mid < end && arr[mid] > arr[mid + 1]) {
            // case 1
            return mid
        } else if (mid > start && arr[mid] < arr[mid - 1]) {
            // case 2
            return mid - 1
        }

        // if elements at start, mid and end are equal, skip the duplicates
        if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
//            Note : We need to just check first if start is not pivot
//            then only we can skip
            if (arr[start] > arr[start + 1]) {
                // then start is pivot, so return it
                return start
            }
            // now if they are not pivots, just skip the elements
            start += 1

            if (arr[end] < arr[end - 1]) {
                // then end is pivot, so return it
                return end - 1
            }
//          now if they are not pivots, just skip the elements
            end -= 1
        }

        // left side is sorted, so pivot should be in right
        else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
            // case 3
            start = mid + 1
        } else {
            // case 4
            end = mid - 1
        }
    }

    return -1
}

fun findPivot(
    arr: IntArray
): Int {
    var start = 0
    var end = arr.size - 1
    while (start <= end) {
        val mid = start + (end - start) / 2

        if (mid < end && arr[mid] > arr[mid + 1]) {
            // case 1
            return mid
        } else if (mid > start && arr[mid] < arr[mid - 1]) {
            // case 2
            return mid - 1
        } else if (arr[start] >= arr[mid]) {
            // case 3
            end = mid - 1
        } else {
            // case 4
            start = mid + 1
        }
    }

    return -1
}