// Question link - https://leetcode.com/problems/find-in-mountain-array/

// Steps required :-
// 1.) Find peak element and divide array in one ascending and one descending order arrays.
// 2.) Apply binary search in asc part.
// 3.) If not found, then apply binary search in desc part.


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

fun findPeak(
    arr: Array<Int>
): Int {
    var start = 0
    var end = arr.size -1
    while (start < end) {
        val mid = start + (end - start) / 2
        if (arr[mid] > arr[mid+1]) {
            // we are in decreasing part, so this may be the answer. But look at left
            // this is why end != mid - 1
            end = mid
        } else if (arr[mid] < arr[mid+1]) {
            // we are in increasing part, so this may be the answer. But look at right
            // because we know mid + 1 is greater than mid element and we are finding
            // greater elements only, so we are ignoring mid element
            start = mid + 1
        }
    }

    // In the end, start & end will point to largest element
    // because of 2 checks.
    // look closely, since start and end are trying to find max element only
    // hence when both start and end will point to same element,
    // that's the maximum element.

    // so we can now return anything, start or end. After running above checks, now
    // they are pointing to same max elements.

    return start
}

