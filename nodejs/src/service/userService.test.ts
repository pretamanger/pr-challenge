import friendTreeBFS from "./userService";
import repository from "../repository/userFriendsRepository";

const mockedRepo = repository as jest.Mocked<typeof repository>;

jest.mock("../repository/userFriendsRepository", () => ({
  default: {
    getUserById: jest.fn(),
    getFriendsById: jest.fn(),
  },
}));

describe("BFS friend tree builder tests", () => {
  beforeEach(() => {
    jest.clearAllMocks();
  });

  test("builds depth-1 friends tree", () => {
    mockedRepo.getUserById.mockReturnValue({
      id: "2",
      name: "User 2",
    });

    mockedRepo.getFriendsById.mockReturnValue([{ id: "3", name: "User 3" }]);

    const result = friendTreeBFS("2", 1);

    expect(result.id).toBe("2");
    expect(result.friends).toEqual([{ id: "3", name: "User 3", friends: [] }]);
  });
});
