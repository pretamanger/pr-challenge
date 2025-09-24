import express from "express";
import { getFriendsForUser } from "./get-friends-for-user.js";

const app = express();

/**
 * Review this route
 */
app.get("/friends", async (req, res) => {
  const { userId } = req.query;

  if (typeof userId !== "string") {
    return res.status(400);
  }

  const friends = await getFriendsForUser(userId);

  return res.json(friends);
});

app.listen(3000);
console.log("Running at http://localhost:3000");
