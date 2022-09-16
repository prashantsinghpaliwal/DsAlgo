// Question Link - https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

/* In this problem, since the array is of infinite length, we dont know the length
 and hence wont make use of arr.length
 
 - We will reverse the binary search approach to find a window 
   or range in which the target exists.
   
 - We start with start = 0 and end = 1
 
 - We keep on increasing this window/range by 2
 
 - E.g. [2,3,4,7,9,11,12,15,23,30,31,34,35,36] and target is 15
 
 - Level 0 -> 2 to 3
 - Level 1 -> 4 to 11
 - Level 2 -> 12 to 36, in this range, the target exists, hence we'll apply binary search here.
 
 Notice we are increasing the window by 2
 
*/

fun main() {
    val arr = arrayOf(2, 3, 4, 7, 9, 11, 12, 15, 23, 30, 31, 34, 35, 36)
    val target = 15
    println(findRange(arr, target))
}

/*  This method finds the range or window
    in which target exists. After finding
    the range we can easily apply binary
    search to find the element's index.
*/
fun findRange(arr: Array<Int>, target: Int): Int {
    var start = 0
    var end = 1

    while (target > arr[end]) {
        val newStart = end + 1
        // double the box value
        // end = prev end + sizeOfBox*2
        end = end + (end - start + 1) * 2
        start = newStart
    }
    
    if (target == arr[end])
        return end
 
    return normalBinarySearch(arr, target, start, end)
}

fun normalBinarySearch(
    arr: Array<Int>,
    target: Int,
    s: Int,
    e: Int
): Int {
    var start = s
    var end = e
    while (start <= end) {
        val mid = start + (end - start) / 2

        // for elements not existing in array, it will throw IndexOutOfBoundException
        // in case target element > last element in ascending order list and vice versa
        if (mid >= arr.size - 1)
            return -1

        if (target < arr[mid]) {
            end = mid - 1
        } else if (target > arr[mid]) {
            start = mid + 1
        } else {
            return mid
        }
    }
    return -1
}
