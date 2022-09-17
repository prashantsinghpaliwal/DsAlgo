// Question Link - https://leetcode.com/problems/find-peak-element/

fun main() {
    val arr = arrayOf(2, 3, 4, 7, 8, 6, 5, 1)
    println(findPeak(arr))
}


fun findPeak(
    arr: Array<Int>
): Int {
    var start = 0
    var end = arr.size -1
    while (start < end) {
        val mid = start + (end - start) / 2
        if (arr[mid] > arr[mid+1]) {
            // we are in decreasing part, so the answer should lie at mid itself or on the left side.
            // this is why end != mid - 1
            end = mid
        } else if (arr[mid] < arr[mid+1]) {
            // we are in increasing part, so the answer should lie at mid itself or on the right side.
            // Also, we know mid + 1 is greater than mid element and we are finding
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

    return arr[start]
}
