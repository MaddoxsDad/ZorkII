import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Dungeon {
  private String title = "";
  private String fileName = null;
  private Room entryRoom = null; // Placeholder for now. Must figure out best way to initialize.
  private Hashtable<String, Room> rooms = new Hashtable<>(); //  Hashtable fir rooms. Stores by their names.

  // Constructor to load dungeon from a file.
  // Will throw exceptions if file not found or format is wrong.
  Dungeon(String fileName) throws FileNotFoundException, IllegalDungeonFormatException {
    this.fileName = fileName;
    this.entryRoom = null;
    Scanner scanner = new Scanner(new File(fileName));
    if(scanner.hasNextLine()) {
       this.title = scanner.nextLine();
    // Starting to parse the file here...
    // Make sure to handle parsing logic correctly below.
    while (scanner.hasNextLine()) {
       String line =scanner.nextLine();
      // Parsing rooms loop. figure out how to break out properly(if wrong).
    }
    scanner.close(); 
  }
}   
  // Overloaded constructor to create different objects depending on info at time of obj creation.
  public Dungeon(String fileName, Room entryRoom) {
    this.fileName = fileName;
    this.entryRoom = entryRoom; // Setting the entry room here, but need to make sure it's used correctly.
    this.add(entryRoom); // Ensure the entry room is added to the list of rooms.
    // May need to expand initialization here later.
  }

  // Method for adding rooms and Now stores rooms in the Hashtable.
  public void add(Room room) {
    this.rooms.put(room.getName(), room);
  }

  // Getter method for dungeon title. Seems straightforward.
  public String getTitle() {
    return this.title;
  }

  // Method to get the entry room. Now ensures entryRoom is set properly.
  public Room getEntry() {
    return entryRoom;
  }

  // Loader method corrected with appropriate construction
  public static Dungeon loadDungeon(String filePath) throws FileNotFoundException, IllegalDungeonFormatException {
    // Correct implementation to load a dungeon from a file
    return new Dungeon(filePath); // Adjusted return statement
  }

  // Custom exception class for dungeon format issues, moved to be static
  public static class IllegalDungeonFormatException extends Exception {
    // Keeping the constructor simple, just trying to use super class.
    public IllegalDungeonFormatException(String message) {
      super(message);
    }
  }
}
