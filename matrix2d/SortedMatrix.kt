package com.byjusexamprep.kunalkushyt.matrix2d

// Question Link -
fun main() {
    val matrix =
        arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60))

    val target = 3
    println(sortedMatrixSearch(matrix, target))
}

// search in the provided row between provided column
fun simpleBinarySearch(
    matrix: Array<IntArray>,
    row: Int,
    columnStart: Int,
    columnEnd: Int,
    target: Int
): IntArray {
    var cStart = columnStart
    var cEnd = columnEnd

    while (cStart < cEnd) {
        val mid = columnStart + (columnEnd - columnStart) / 2
        if (matrix[row][mid] == target) {
            return intArrayOf(row, mid)
        }

        if (matrix[row][mid] < target) {
            cStart = mid + 1
        } else {
            cEnd = mid - 1
        }
    }

    return intArrayOf(-1, -1)
}

fun sortedMatrixSearch(matrix: Array<IntArray>, target: Int): IntArray {

    val rows = matrix.size
    val cols = matrix[0].size

    if (rows == 1) {
        return simpleBinarySearch(matrix, 0, 0, cols - 1, target)
    }

    // run the loop till rows are remaining
    var rowStart = 0
    var rowEnd = rows - 1
    val columnMid = cols / 2
    while (rowStart < (rowEnd - 1)) {
        // while its true, it will have more than two rows
        // so we will try to eliminate them

        val mid = rowStart + (rowEnd - rowStart) / 2
        if (matrix[mid][columnMid] == target) {
            return intArrayOf(mid, columnMid)
        }

        if (matrix[mid][columnMid] < target) {
            // ignore above rows
            rowStart = mid
        } else {
            rowEnd = mid
        }
    }

    // after above loop has run, we will have only two rows
    // check whether the target is in column of 2 rows middle

    if (matrix[rowStart][columnMid] == target) {
        return intArrayOf(rowStart, columnMid)
    }

    if (matrix[rowStart + 1][columnMid] == target) {
        return intArrayOf(rowStart + 1, columnMid)
    }

    // otherwise search in 1st half
    if (target <= matrix[rowStart][columnMid - 1]) {
        return simpleBinarySearch(matrix, rowStart, 0, columnMid - 1, target)
    }

    // 2nd half,
    if (target >= matrix[rowStart][columnMid + 1]
        && target <= matrix[rowStart][cols - 1]
    ) {
        return simpleBinarySearch(matrix, rowStart, 0, columnMid + 1, target)
    }

    // 3rd half,
    if (target >= matrix[rowStart + 1][columnMid - 1]) {
        return simpleBinarySearch(matrix, rowStart + 1, 0, columnMid - 1, target)
    }

    // 4th half
    else {
        return simpleBinarySearch(matrix, rowStart + 1, 0, columnMid + 1, target)
    }

}