import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Dungeon {

    private String title = "";
    private Room entry = null;
    private Hashtable<String,Room> rooms = new Hashtable<>();
    private String fileName = null; //Added instance variable for file name

    Dungeon(String title, Room entry) {
        this.title = title;
        this.entry = entry;
        this.add(this.entry);
    }

       //Hydration constructor takes fileName starts scanner
    Dungeon(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        Scanner scanner = new Scanner(new File(fileName));//Read and set dungeon title
        if (scanner.hasNextLine()) {
        this.title = scanner.nextLine();
    }
        scanner.close();
}
    public Room getEntry() { return this.entry; }
    public String getTitle() { return this.title; }
    public void add(Room room) { this.rooms.put(room.getName(), room); }

    public Room getRoom(String roomName) {
        return this.rooms.get(roomName); 
  }  
    public static class IllegalDungeonFormatException extends Exception {
        public IllegalDungeonFormatException(String message) {
            super(message);      
    }
}    
     public static class IllegalSaveFormatException extends Exception {
        public IllegalSaveFormatException(String message) {
            super(message);
    }
  }
     public static class NoRoomException extends Exception {
        public NoRoomException(String message) {
            super(message);
        }
    }
     public static class NoExitException extends Exception {
        public NoExitException(String message) {
            super(message);
    }
  }
}
