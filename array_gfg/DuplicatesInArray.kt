package com.byjusexamprep.kunalkushyt.array_gfg

fun main() {
    val arr = arrayOf(1,3,4,2,2)
    println(findDuplicates(arr))
}

private fun findDuplicates(arr: Array<Int>): MutableList<Int> {
    val map = mutableMapOf<Int, Int>()
    arr.forEach { number ->
        map[number] = (map[number] ?: 0) + 1
    }

    val list = mutableListOf<Int>()
    map.forEach {
        if ((map[it.key] ?:0)  > 1)
            list.add(it.key)
    }

    return list
}

