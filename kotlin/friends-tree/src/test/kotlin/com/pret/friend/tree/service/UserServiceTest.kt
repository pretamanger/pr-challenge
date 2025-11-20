package com.pret.friend.tree.service


import com.pret.friend.tree.abstractions.User
import com.pret.friend.tree.repository.UserFriendsRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserServiceTest {

    private val userFriendsRepository: UserFriendsRepository = mockk()
    private val underTest = UserService(userFriendsRepository)

    @Test
    fun shouldReturnRootUserWithoutFriend() {
        every { userFriendsRepository.getUserById(1) } returns User(1, "Jasmin")


        val result = underTest.friendTreeBfs(1, 0)

        assertThat(result.id).isEqualTo(1)
        assertThat(result.name).isEqualTo("Jasmin")
        assertThat(result.friends).isEmpty()

        verify { userFriendsRepository.getUserById(1) }
    }

    @Test
    fun shouldReturnRootUserWithLevel1Friends() {
        every { userFriendsRepository.getUserById(1) } returns User(1, "Jasmin")
        every { userFriendsRepository.getFriendsById(1) } returns listOf(User(2, "Peter"))

        val result = underTest.friendTreeBfs(1, 1)

        assertThat(result.id).isEqualTo(1)
        assertThat(result.name).isEqualTo("Jasmin")
        assertThat(result.friends).isNotEmpty

        assertThat(result.friends[0].id).isEqualTo(2)
        assertThat(result.friends[0].name).isEqualTo("Peter")
        assertThat(result.friends[0].friends).isEmpty()


        verify { userFriendsRepository.getUserById(1) }
        verify { userFriendsRepository.getFriendsById(1) }
    }

    @Test
    fun shouldReturnRootUserWithLevel2Friends() {
        every { userFriendsRepository.getUserById(1) } returns User(1, "Jasmin")
        every { userFriendsRepository.getFriendsById(1) } returns listOf(User(2, "Peter"))
        every { userFriendsRepository.getFriendsById(2) } returns listOf(User(3, "Jack"))

        val result = underTest.friendTreeBfs(1, 2)

        assertThat(result.id).isEqualTo(1)
        assertThat(result.name).isEqualTo("Jasmin")
        assertThat(result.friends).isNotEmpty

        assertThat(result.friends[0].id).isEqualTo(2)
        assertThat(result.friends[0].name).isEqualTo("Peter")
        assertThat(result.friends[0].friends).isNotEmpty


        assertThat(result.friends[0].friends[0].id).isEqualTo(3)
        assertThat(result.friends[0].friends[0].name).isEqualTo("Jack")
        assertThat(result.friends[0].friends[0].friends).isEmpty()

        verify { userFriendsRepository.getUserById(1) }
        verify { userFriendsRepository.getFriendsById(1) }
        verify { userFriendsRepository.getFriendsById(2) }
    }

}