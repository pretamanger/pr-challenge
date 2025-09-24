import axios from "axios";
import type { RequestHandler } from "express";
import { EXTERNAL_FRIENDS_SERVICE_BASE_URL } from "../../external-friends-service/constants.js";

export const friendsRoute: RequestHandler = async (req, res) => {
  const { userId } = req.query;

  if (typeof userId !== "string") {
    return res.status(400);
  }

  const friends = await axios.get(
    `${EXTERNAL_FRIENDS_SERVICE_BASE_URL}/external-friends-service?userId=${userId}`
  );

  return res.json(friends.data);
};
