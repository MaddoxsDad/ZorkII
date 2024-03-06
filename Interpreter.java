import java.util.Scanner;
import java.io.IOException;

public class Interpreter {

  public static void main(String args[]) {
    if (args.length != 1 || (!args[0].endsWith(".zork") && !args[0].endsWith(".sav"))) {
      System.out.println("Usage: Interpreter zorkFile.zork|saveFile.sav");
      return;
    }

    String filePath = args[0];
    GameState state = GameState.instance();

    try (Scanner commandLine = new Scanner(System.in)) { // try-with-resources for managing Scanner
      if (filePath.endsWith(".zork")) {
        // Assume Dungeon.loadDungeon does the appropriate error handling or throws a specific exception
        Dungeon loadedDungeon = Dungeon.loadDungeon(filePath);
        state.initialize(loadedDungeon);
      } else {
        // Similarly for GameState.loadGameState
        GameState.loadGameState(filePath);
      }

      System.out.println("\nWelcome to " + state.getDungeon().getTitle() + "!");
      System.out.print("\n" + state.getAdventurersCurrentRoom().describe() + "\n");

      String command;
      do {
        System.out.print("> ");
        command = commandLine.nextLine(); // Directly using Scanner without a method call
        System.out.print(CommandFactory.instance().parse(command).execute());
      } while (!command.equals("q"));

      System.out.println("Bye!");

    } catch (IOException e) { // Catching specific exception as an example
      System.err.println("An error occurred with input or output.");
      e.printStackTrace();
    } catch (Exception e) { // General exception catch as fallback
      System.err.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
