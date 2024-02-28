
import java.util.ArrayList;

public class Room {

    private String name;
    private String desc;
    private ArrayList<Exit> exits;

    Room(String name) {
        this.name = name;
        this.exits = new ArrayList<Exit>();
    }

    String getName() { return this.name; }

    void setDesc(String desc) { this.desc = desc; }

    public String describe() {
        String description;
        if (GameState.instance().hasBeenVisited(this)) {
            description = this.name;
        } else {
            description = this.name + "\n" + this.desc + "\n";
        }
        for (Exit exit : this.exits) {
            description += "\n" + exit.describe();
        }
        GameState.instance().visit(this);
        return description;
    }
    
    public Room leaveBy(String dir) {
        for (Exit exit : this.exits) {
            if (exit.getDir().equals(dir)) {
                return exit.getDest();
            }
        }
        return null;
    }

    void addExit(Exit exit) {
        this.exits.add(exit);
    }
}
