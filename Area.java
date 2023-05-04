import java.util.*;

public class Area{

    String name;
    String description;
    private ArrayList<String> enemyList;
    private HashMap<String, Actor> enemies;
    private ArrayList<String> objectList;
    private HashMap<String, String> objects;
    ArrayList<String> exits;

    public Area(String name, String description){
        this.name = name.toLowerCase();
        this.description = description;
        this.enemyList = new ArrayList<String>();
        this.enemies = new HashMap<String, Actor>();
        this.objectList = new ArrayList<String>();
        this.objects = new HashMap<String, String>();
        this.exits = new ArrayList<String>();
    }

    //get area name
    public String getName(){
        return this.name;
    }

    //get area description
    public String getDescription(){
        return this.description;
    }

    //adds exit to area
    //and logs it
    public void addExit(String exit, IO io){
        io.log("\t\t-Exit: " + exit + " to " + this.name + "\n");
        this.exits.add(exit.toLowerCase());
    }


    public void addExit(String exit){
        this.exits.add(exit.toLowerCase());
    }

    //checks if room contains exit
    public boolean containsExit(String exit){
        return this.exits.contains(exit);
    }

    //adds enemy to area then logs it
    public void addEnemy(Actor enemy, IO io){

        io.log("\t\t-Enemy name: " + enemy.getName() + " to " + this.name + "\n");
        this.enemyList.add(enemy.getName());
        this.enemies.put(enemy.getName(), enemy);
    }

    public void addEnemy(Actor enemy){

        this.enemyList.add(enemy.getName());
        this.enemies.put(enemy.getName(),enemy);
    }


    //gets enemy object
    public Actor getEnemy(String enemyName){

        return this.enemies.get(enemyName);
    }

    //removes enemy from room
    public boolean removeEnemy(String enemy){

        for(int i = 0; i < this.enemyList.size(); i++){

            if(this.enemyList.get(i) == enemy){

                this.enemies.remove(this.enemyList.get(i));
                this.enemyList.remove(i);

                return true;
            }
        }
        return false;
    }

    //checks if enemy is in room
    public boolean containsEnemy(String enemyName){

        return enemyList.contains(enemyName);
    }

    //adds object to room then logs it
    public void addObject(String objectName, String description, IO io){

        io.log("\t\t-Object name: " + objectName + " to " + this.name + "\n");
        this.objectList.add(objectName);
        io.log("\t\t-Object descritption: " + description + "\n");
        this.objects.put(objectName, description);
    }

    public void addObject(String objectName, String description){

        this.objectList.add(objectName);
        this.objects.put(objectName, description);
    }

    //checks if object is in room
    public boolean containsObject(String objectName){

        return objectList.contains(objectName);
    }

    //gets object name
    public String getObject(String objectName){

        return this.objects.get(objectName);
    }

    //formats room exits in list format
    public String listExits(){

        String exits = "";

        if(this.exits.size() > 0){

            for(int i = 0; i < this.exits.size(); i++){

                if(i == this.exits.size() - 1){
                    exits += "-" + this.exits.get(i);
                    break;
                } else exits += "-" + this.exits.get(i) + "\n";
            }

        }else return "No Exits";

        return exits;
    }

    //formats room enemies in list format
    public String listEnemies(){

        String enemyList = "";

        if(this.enemyList.size() > 0){

            for(int i = 0; i < this.enemyList.size(); i++){

                if(i == this.enemyList.size() - 1){
                    enemyList += "-" + this.enemyList.get(i);
                    break;
                } else enemyList += "-" + this.enemyList.get(i) + "\n";
            }
        }else return "No Enemies";

        return enemyList;
    }

    //formats room objects in list format
    public String listObjects(){

        String objectList = "";

        if(this.objectList.size() > 0){

            for(int i = 0; i < this.objectList.size(); i++){

                if(i == this.objectList.size() - 1){
                    objectList += "-" + this.objectList.get(i);
                    break;
                } else objectList += "-" + this.objectList.get(i) + "\n";
            }
        }else return "No Objects";

        return objectList;
    }

    //prints room exits
    public void printExits(){
        System.out.println("Exits:");
        System.out.println(this.listExits());
    }

    //prints room enemies
    public void printEnemies(){
        System.out.println("Enemies:");
        System.out.println(this.listEnemies());
    }

    //prints room objects
    public void printObjects(){
        System.out.println("Objects:");
        System.out.println(this.listObjects());
    }

    public String toString(){
       return this.name + ": " + this.description;
    }

}
