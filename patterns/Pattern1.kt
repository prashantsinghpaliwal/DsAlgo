package com.byjusexamprep.kunalkushyt.patterns

/*

*****
*****
*****
*****
*****

Print this pattern with n row and column
*/

fun main() {
    printPattern1(5,5)
}

fun printPattern1(row: Int, col: Int) {
    for (row in 1..row) {
        for (j in 1..col) {
            print("*")
        }

        println()
    }
}