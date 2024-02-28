
// For now, only direction commands. If the "direction" is bogus, then this
// effectively doubles as an UnknownCommand (to be a subclass later).
public class Command {

    private String dir;     // for now, this class is only for direction 
                            // commands.

    Command(String dir) {
        this.dir = dir;
    }

    public String execute() {
        if (this.dir.equals("n") || this.dir.equals("w") ||
            this.dir.equals("e") || this.dir.equals("s") ||
            this.dir.equals("u") || this.dir.equals("d")) {
            Room currentRoom = 
                GameState.instance().getAdventurersCurrentRoom();
            Room nextRoom = currentRoom.leaveBy(this.dir);
            if (nextRoom != null) {
                GameState.instance().setAdventurersCurrentRoom(nextRoom);
                return "\n" + nextRoom.describe() + "\n";
            } else {
                return "Sorry, you can't go " + dir + " from " +
                    currentRoom.getName() + ".\n";
            }
        }
        return "I'm sorry, I don't understand the command '" + dir + "'.\n";
    }
}
