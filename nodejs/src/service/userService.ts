import { FriendNode, User } from "../types/general";
import repository from "../repository/userFriendsRepository";

const friendTreeBFS = (startId: string, maxDepth: number): FriendNode => {
  const rootUser = repository.getUserById(startId) as User;

  const rootNode: FriendNode = {
    id: rootUser.id,
    name: rootUser.name,
    friends: [],
  };

  const queue: Array<{ node: FriendNode; depth: number }> = [
    { node: rootNode, depth: 0 },
  ];

  const visited = new Set<string>();
  visited.add(startId);

  while (queue.length > 0) {
    const { node, depth } = queue.shift()!;

    if (depth >= maxDepth) continue;

    const friends = repository.getFriendsById(node.id);

    for (const friend of friends) {
      if (visited.has(friend.id)) continue;

      visited.add(friend.id);

      const child: FriendNode = {
        id: friend.id,
        name: friend.name,
        friends: [],
      };

      node.friends.push(child);
      queue.push({ node: child, depth: depth + 1 });
    }
  }

  return rootNode;
};

export default friendTreeBFS;
