import userFriendsRepository from "./userFriendsRepository";

describe("userFriendsRepository unit tests", () => {
  test("should get User By Id", () => {
    const user = userFriendsRepository.getUserById("1");
    expect(user).toEqual({ id: "1", name: "Alicia Keys" });
  });

  test("should get Friends By Id", () => {
    const friends = userFriendsRepository.getFriendsById("2");

    expect(friends.map((f) => f.id).sort()).toEqual(["3", "4", "7", "9"]);
  });
});
