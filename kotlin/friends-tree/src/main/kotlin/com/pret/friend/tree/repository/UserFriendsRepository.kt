package com.pret.friend.tree.repository

import com.pret.friend.tree.data.DataComponent
import com.pret.friend.tree.abstractions.User
import org.springframework.stereotype.Repository

@Repository
class UserFriendsRepository(
    private val dataComponent: DataComponent
) {

    fun getFriendsById(userId: Int) =
        dataComponent.friendships().filter { it.first == userId }
            .map { friendShipPair ->
                getUserById(friendShipPair.second)
            }

    fun getUserById(userId: Int): User = dataComponent.users().first { it.id == userId }
}