
import java.util.Scanner;
import java.io.IOException;

public class Interpreter {

    public static void main(String args[]) {

        try {
            GameState state = GameState.instance();
            state.initialize(buildSampleDungeon());

            String command;
            Scanner commandLine = new Scanner(System.in);
            System.out.println("\nWelcome to " +
                state.getDungeon().getTitle() + "!");

            System.out.print("\n" + 
                state.getAdventurersCurrentRoom().describe() + "\n");

            command = promptUser(commandLine);

            while (!command.equals("q")) {

                System.out.print(
                    CommandFactory.instance().parse(command).execute());

                command = promptUser(commandLine);
            }

            System.out.println("Bye!");

        } catch(Exception e) { 
            e.printStackTrace(); 
        }
    }

    private static String promptUser(Scanner commandLine) 
        throws IOException {

        System.out.print("> ");
        return commandLine.nextLine();
    }

    private static Dungeon buildSampleDungeon() {
        Room rotunda = new Room("Rotunda");
        rotunda.setDesc(
"You are in a beautiful round room, with a ceiling that seemingly reaches\n" +
"to the skies. There is an elevator here.");
        Room basement = new Room("Basement hallway");
        basement.setDesc(
"A long, white hallway stretches to the east and west. It is cold here,\n" +
"and you can detect the faint smell of body odor. A vending machine hums\n" +
"softly in the corner.");
        Room backHallway = new Room("Back hallway");
        backHallway.setDesc(
"A smaller, cozier hallway greets your eye. A small kitchen area with a\n" +
"purring coffee machine is on one side, and on the other, a row of\n" +
"welcoming office doors. One has Star Wars insignias on it.");
        Room stephensOffice = new Room("Stephen's office");
        stephensOffice.setDesc(
"This is a cluttered office, with many geeky toys. Dr. Anewalt finds it\n" +
"cold in here.");
        Room oh44 = new Room("Room 044");
        oh44.setDesc(
"Sunlight streams through tall windows and illuminates a jolly little\n" +
"classroom. The students in it can see you through the door windows. They\n"+
"smile and wave.");
        Room balcony = new Room("Rotunda balcony");
        balcony.setDesc(
"You stand on a circular white balcony overlooking an entry hall. Columnar\n" +
"bannisters in ancient Grecian style stand between you and the precipice.");
        new Exit("d",rotunda,basement);
        new Exit("u",basement,rotunda);
        new Exit("d",balcony,rotunda);
        new Exit("u",rotunda,balcony);
        new Exit("w",basement,backHallway);
        new Exit("e",basement,oh44);
        new Exit("n",oh44,basement);
        new Exit("w",oh44,backHallway);
        new Exit("s",backHallway,stephensOffice);
        new Exit("n",stephensOffice,backHallway);
        new Exit("e",backHallway,oh44);
            
        Dungeon sampleDungeon = new Dungeon("Farmer", rotunda);
        sampleDungeon.add(basement);
        sampleDungeon.add(backHallway);
        sampleDungeon.add(stephensOffice);
        sampleDungeon.add(oh44);
        sampleDungeon.add(balcony);
        return sampleDungeon;
    }

}
