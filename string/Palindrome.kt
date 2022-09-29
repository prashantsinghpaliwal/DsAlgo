package com.byjusexamprep.kunalkushyt.string


fun main() {
    val string = "A man, a plan, a canal: Panama"
    println(isPalindrome(string))
}


fun isPalindrome(s: String): Boolean {
    val validString: String = s.filter { it.isLetterOrDigit() }
    val chars = validString.toLowerCase().toCharArray()
    var start = 0
    var end = chars.size - 1
    while (start <= end) {
        if (chars[start] == chars[end]) {
            start++
            end--
        } else {
            return false
        }
    }

    return true
}