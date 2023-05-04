import java.util.ArrayList;

public class Area{

    String name;
    String description;
    private static Actor[] enemies;
    ArrayList<String> exits;

    public Area(String name, String description){
        this.name = name.toLowerCase();
        this.description = description;
        this.exits = new ArrayList<String>();
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void addExit(String exit){
        this.exits.add(exit.toLowerCase());
    }

    public String listExits(){
        String exits = "";
        System.out.println("Exits:");
        for(String room : this.exits){
            exits += room + Character.toString('\n');
        }
        return exits;
    }

    public void printExits(){
        String exits = "";
        System.out.println("Exits:");
        for(String room : this.exits){
            System.out.printf("%s\n", room);
        }
    }

    public String toString(){
       return this.name + ": " + this.description;
    }

    public boolean containsExit(String exit){
        return this.exits.contains(exit);
    }
}
