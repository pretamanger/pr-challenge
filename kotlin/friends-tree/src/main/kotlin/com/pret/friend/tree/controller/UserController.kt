package com.pret.friend.tree.controller

import com.pret.friend.tree.abstractions.UserNode
import com.pret.friend.tree.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/friends")
class UserController(
    private val userService: UserService
) {

    @GetMapping()
    fun getMatches(
        @RequestParam userId: Int,
        @RequestParam depth: Int?,
    ): UserNode = userService.friendTreeBfs(userId, depth ?: 0)
}