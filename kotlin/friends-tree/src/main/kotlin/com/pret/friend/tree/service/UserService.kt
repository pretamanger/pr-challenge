package com.pret.friend.tree.service

import com.pret.friend.tree.abstractions.UserNode
import com.pret.friend.tree.repository.UserFriendsRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userFriendsRepository: UserFriendsRepository
) {

    fun friendTreeBfs(rootUserId: Int, maxDepth: Int): UserNode {
        val rootUser = userFriendsRepository.getUserById(rootUserId)
        val rootNode = UserNode(rootUser.id, rootUser.name)

        val visited = mutableSetOf(rootUserId)
        val queue: ArrayDeque<Triple<UserNode, Int, Int>> = ArrayDeque()

        queue.add(Triple(rootNode, rootUserId, 0))

        while (queue.isNotEmpty()) {
            val (parentNode, currentUserId, depth) = queue.removeFirst()

            if (depth == maxDepth) continue

            val friends = userFriendsRepository.getFriendsById(currentUserId)

            for (friend in friends) {
                if (friend.id !in visited) {
                    visited.add(friend.id)

                    val childNode = UserNode(friend.id, friend.name)
                    parentNode.friends.add(childNode)

                    queue.add(Triple(childNode, friend.id, depth + 1))
                }
            }
        }

        return rootNode
    }

}