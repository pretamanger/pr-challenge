import express from "express";
import { externalFriendsServiceRoute } from "../external-friends-service/external-friends-service.route.js";
import { friendsRoute } from "./routes/friends.route.js";

const app = express();

/**
 * Review this route handler
 */
app.get("/friends", friendsRoute);

/**
 * Assume this is a third-party API and can't be changed
 */
app.get("/external-friends-service", externalFriendsServiceRoute);

app.listen(3000);
console.log("Running at http://localhost:3000");
