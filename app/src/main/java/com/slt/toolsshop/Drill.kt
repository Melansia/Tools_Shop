package com.slt.toolsshop

data class Drill(
    val title: String,
    val info: String,
    val imageResource: Int
) {
    override fun toString(): String {
        return title
    }
}