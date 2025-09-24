# PR Challenge

## Context

Imagine Pret is building a new 'friends' feature on the app, where customers can connect to share loyalty rewards, and more.

Initially the requirement for this API was just to load immediate connections, but now we want to expand the feature so that customers can explore who their friends' friends are, then continue exploring the network of friends, like a social network.

The PR changes the response of the API endpoint so that it now returns a tree structure of friends that will be sent back to the Pret app.

Run it locally, see it in action, and review the changes.

## Running the API

1. Clone the repository
2. Install `pnpm` globally if you don't have it yet
3. Run `pnpm install`
4. Run `pnpm start`
5. Send a `GET` request to `http://localhost:3000/friends?userId=1`
6. Try changing the user ID in the query

## Reviewing the PR

Add comments in the code to `friends.route.ts`.
