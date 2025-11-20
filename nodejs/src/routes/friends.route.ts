import type { RequestHandler } from "express";
import friendTreeBFS from "../service/userService.js";

export const friendsRoute: RequestHandler = async (req, res) => {
  const { userId, depth } = req.query;

  if (typeof userId !== "string") {
    return res.status(400);
  }
  return res.json(friendTreeBFS(userId, Number(depth) ?? 0));
};
