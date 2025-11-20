export interface User {
  id: string;
  name: string;
}

export interface FriendNode {
  id: string;
  name: string;
  friends: FriendNode[];
}
