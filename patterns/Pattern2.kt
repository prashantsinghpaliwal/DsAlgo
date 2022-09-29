package com.byjusexamprep.kunalkushyt.patterns

/*

*
**
***
****
*****

Print this pattern with n row and column
*/

fun main() {
    printP2(10)
}

fun printP2(n: Int) {
    for (row in 1..n) {
        for (j in 1..row) {
            print("*")
        }
        // when one row is printed, print a new line
        println()
    }
}