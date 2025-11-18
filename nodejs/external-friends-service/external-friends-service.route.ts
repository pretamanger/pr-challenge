import type { RequestHandler } from "express";
import { getFriendsForUser } from "./get-friends-for-user.js";

export const externalFriendsServiceRoute: RequestHandler = async (req, res) => {
  const { userId } = req.query;

  if (typeof userId !== "string") {
    return res.status(400).send();
  }

  const friends = await getFriendsForUser(userId);

  return res.json(friends);
};
