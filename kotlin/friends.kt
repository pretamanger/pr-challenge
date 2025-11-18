class NetworkDataSource {

    fun getFriends(
        userId: String
    ): NodeResponse? {
        // Implementation here
    }
}

class NodeResponse(
    var id: String,
    var name: String,
    var friendIds: List<String>,
)

class Node(
    var id: String,
    var name: String,
    var friends: List<Node>,
)

// Entry point
fun getFriends(
    userId: String
): Node {
    return getFriendsRecursively(userId)
}

private fun getFriendsRecursively(
    userId: String
): Node {
    val response = NetworkDataSource().getFriends(userId)
    val friendNodes = response!!.friendIds.map {
        getFriendsRecursively(it)
    }

    return Node(
        response.name,
        response.id,
        friendNodes
    )
}
