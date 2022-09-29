package com.byjusexamprep.kunalkushyt.patterns


/*

*
**
***
****
*****
****
***
**
*

Print this pattern with n row and column
*/

fun main() {
    printPattern5(5)
}

fun printPattern5(n: Int) {
    for (row in 0 until 2 * n) {
        val totalColsInRow = if (row > n) 2 * n - row else row
        for (j in 0 until totalColsInRow) {
            print("* ")
        }
        println()
    }
}