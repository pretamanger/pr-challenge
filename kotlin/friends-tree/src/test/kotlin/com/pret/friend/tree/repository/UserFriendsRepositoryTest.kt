package com.pret.friend.tree.repository

import com.pret.friend.tree.data.DataComponent
import com.pret.friend.tree.abstractions.User
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserFriendsRepositoryTest {

    private val dataComponent: DataComponent = mockk()

    private val underTest = UserFriendsRepository(dataComponent)

    @Test
    fun willGetUserById() {
        every { dataComponent.users() } returns setOf(User(2, "Julian"))

        val result = underTest.getUserById(2)

        assertThat(result.id).isEqualTo(2)
        assertThat(result.name).isEqualTo("Julian")

        verify { dataComponent.users() }
    }

    @Test
    fun willUserFriends() {
        every { dataComponent.friendships() } returns setOf(Pair(2, 4))
        every { dataComponent.users() } returns setOf(User(4, "Joe"))

        val result = underTest.getFriendsById(2)

        assertThat(result).isEqualTo(listOf(User(4, "Joe")))

        verify { dataComponent.users() }
        verify { dataComponent.friendships() }
    }
}