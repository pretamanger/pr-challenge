import { User } from "../types/general";
import { users } from "../../external-friends-service/users";
import { friendships } from "../../external-friends-service/friendships";

const userFriendsRepository = {
  getUserById(id: string): User | undefined {
    return users.find((u) => u.id === id);
  },

  getFriendsById(userId: string): User[] {
    return friendships
      .filter(([a]) => a === userId)
      .map(([_, friendId]) => this.getUserById(friendId as string))
      .filter((u): u is User => u !== undefined);
  },
};

export default userFriendsRepository;
