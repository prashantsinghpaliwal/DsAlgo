package com.byjusexamprep.kunalkushyt.recursion

fun main() {
    val n = 15 // No of players in the game
    val k = 3 // player to be skipped
    println(findSafePosition(n, k))
}

// this solution is known as JosePhus solution
fun findSafePosition(n: Int, k: Int): Int{

    return if (n == 1)
        1
    else
    /* The position returned by findSafePosition(n - 1, k) is adjusted because the
       recursive call findSafePosition(n - 1, k) considers the original position
       k%n + 1 as position 1 */
        ((findSafePosition(n - 1, k) + k-1) % n + 1)
}