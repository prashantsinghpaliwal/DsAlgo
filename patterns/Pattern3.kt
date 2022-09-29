package com.byjusexamprep.kunalkushyt.patterns

/*

*****
****
***
**
*

Print this pattern with n row and column
*/

fun main() {
    printPattern3(5)
}

fun printPattern3(n: Int) {
    for (row in 0 until n) {
        for (j in n - row downTo 1) {
            print("*")
        }
        println()
    }
}