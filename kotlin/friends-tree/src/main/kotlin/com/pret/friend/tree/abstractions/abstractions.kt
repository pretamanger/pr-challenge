package com.pret.friend.tree.abstractions

data class User(val id: Int, val name: String)

data class UserNode(
    val id: Int,
    val name: String,
    val friends: MutableList<UserNode> = mutableListOf()
)


