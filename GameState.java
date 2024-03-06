import java.util.HashSet;

public class GameState {

  private static GameState theInstance = null;
  private Dungeon dungeon = null;
  private Room adventurersCurrentRoom = null;
  private HashSet<Room> visitedRooms;

  public static synchronized GameState instance() {
    if (theInstance == null) {
      theInstance = new GameState();
    }
    return theInstance;
  }
//initializes the game state with a given dungeon
  private GameState() {
    this.visitedRooms = new HashSet<Room>();
  }

  void initialize(Dungeon dungeon) {
    this.dungeon = dungeon;
    this.adventurersCurrentRoom = this.dungeon.getEntry();
  }

  Room getAdventurersCurrentRoom() {
    return this.adventurersCurrentRoom;
  }
//pdates the players current room to a new room,
  void setAdventurersCurrentRoom(Room room) {
    this.adventurersCurrentRoom = room;
  }

  Dungeon getDungeon() {
    return this.dungeon;
  }
//checks if roooms been visisted
  boolean hasBeenVisited(Room r) {
    return this.visitedRooms.contains(r);
  }

  void visit(Room r) {
    this.visitedRooms.add(r);
  }

  public void setDungeon(Dungeon d) {
    this.dungeon = d;
  }
 

  public static void loadGameState(String filePath) {
      // To be continued...
      // Needs to open the file, parse its contents, and use it to set up the game state
  }
}
