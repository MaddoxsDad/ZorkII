
public class Exit {

    private String dir;
    private Room src, dest;

    Exit(String dir, Room src, Room dest) {
        this.dir = dir;
        this.src = src;
        this.dest = dest;
        src.addExit(this);
    }

    String describe() {
        return "You can go " + this.dir + " to " + this.dest.getName() + ".";
    }

    String getDir() { return this.dir; }
    Room getSrc() { return this.src; }
    Room getDest() { return this.dest; }
}
