
import java.util.HashSet;

public class GameState {

    private static GameState theInstance;
    private Dungeon dungeon;
    private Room adventurersCurrentRoom;
    private HashSet<Room> visitedRooms;

    public static synchronized GameState instance() {
        if (theInstance == null) {
            theInstance = new GameState();
        }
        return theInstance;
    }

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

    void setAdventurersCurrentRoom(Room room) {
        this.adventurersCurrentRoom = room;
    }

    Dungeon getDungeon() {
        return this.dungeon;
    }

    boolean hasBeenVisited(Room r) {
        return this.visitedRooms.contains(r);
    }

    void visit(Room r) {
        this.visitedRooms.add(r);
    }
}
