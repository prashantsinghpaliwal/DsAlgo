package com.byjusexamprep.kunalkushyt.matrix2d

// this matrix is only sorted row wise & column wise.
// For fully sorted matrix search, see another file Named "SortedMatrix"

//Question Link - https://leetcode.com/problems/search-a-2d-matrix-ii/

fun main() {
    val matrix =
//        arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60))
        arrayOf(intArrayOf(1, 3))

    val target = 3
    println(searchIn2DMatrix(matrix, target))
}

fun searchIn2DMatrix(matrix: Array<IntArray>, target: Int): String {
    var row = 0
    var col = matrix.size - 1
    while(row < matrix.size && col >= 0){
        if(target == matrix[row][col]){
            return "$target found at [$row][$col]"
        }

        if(target > matrix[row][col]){
            row++
        } else {
            col--
        }
    }

    return "$target not found"
}

