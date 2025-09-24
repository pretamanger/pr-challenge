import { users } from "./users.js";
import { friendships } from "./friendships.js";

/**
 * Mock database call for the purposes of the challenge.
 * No need to review this.
 */
export async function getFriendsForUser(userId: string) {
  return new Promise((resolve) => {
    const friends = friendships
      .map(([userId1, userId2]) => {
        const isMatchingFriendship = userId === userId1 || userId === userId2;

        if (!isMatchingFriendship) {
          return undefined;
        }

        const friendId = userId === userId1 ? userId2 : userId1;
        const friend = users.find((user) => user.id === friendId);

        return friend;
      })
      .filter((friend) => !!friend);

    setTimeout(() => {
      resolve(Array.from(new Set(friends)));
    }, 500);
  });
}
