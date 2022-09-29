package com.byjusexamprep.kunalkushyt.patterns

/*

1
1 2
1 2 3
1 2 3 4
1 2 3 4 5

Print this pattern with n row and column
*/

fun main() {
    printPattern4(5)
}

fun printPattern4(n: Int) {
    for (row in 1..n) {
        for (j in 1..row) {
            print("$j ")
        }
        println()
    }
}