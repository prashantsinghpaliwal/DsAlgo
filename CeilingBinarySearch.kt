// Ceiling = smallest element in array > = target 
// e.g. arr = [2, 12, 21, 23, 33, 37, 38, 40, 41]
// and target = 36
// then ceiling is an element just after 36, i.e, 37

fun ceilingBinarySearch(arr: Array<Int>, target: Int): Int {
    var start = 0
    var end = arr.size
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
    return start
}
