package com.pret.friend.tree.controller

import com.ninjasquad.springmockk.MockkBean
import com.pret.friend.tree.abstractions.UserNode
import com.pret.friend.tree.service.UserService
import io.mockk.every
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@WebMvcTest(UserController::class)
class UserControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockkBean
    private lateinit var userService: UserService

    @Test
    fun shouldGetUserFriendsTree() {
        every { userService.friendTreeBfs(1, 1) } returns UserNode(1, "Jack")

        val response = mvc.perform(
            get("/user?userId=1&depth=1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().response

        assertThat(response.status).isEqualTo(HttpStatus.OK.value())

        verify { userService.friendTreeBfs(1, 1) }
    }
}