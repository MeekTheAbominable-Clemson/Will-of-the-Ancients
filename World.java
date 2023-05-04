import java.util.*;

public class World{

    private static Map map;
    private static Actor player;
    private static IO io;
    private static boolean requiresUpdate;

    //default
    public World(){
        this.map = new Map();
        this.player = new Actor();
        this.io = new IO();
        this.map.addArea(new Area("Purgatory", "You feel cold and utterly alone. What did you do to deserve a fate like this?"), io);
    }

    //sets up world with map player and io
    public World(Map m, Actor p, IO io){
        this.map = m;
        this.player = p;
        this.io = io;
        this.map.addArea(new Area("Purgatory", "You feel cold and utterly alone. What did you do to deserve a fate like this?"), io);
        //logs game start message
        io.log("World Created!\n");
        io.log("Have Fun!\n");
        io.log("-----------------------------------------------------------------------------------------------------------------------------------------------------\n");
        io.log("-Gameplay:\n");
    }

    public void action(Command command){

        //checks command type to decide how game logic should proceed
        switch(command.getType()){

            case "move":

                //move will allow player to change current room
                //and logs what happens
                if(this.player.travelTo(command.optionsAsString(), this.map)){
                    io.log("-Moving: \n");
                    io.log("\tto: " + command.optionsAsString() + "\n");
                    System.out.println(player.getLocation() + ":");
                    io.log("\tdescription: " + this.map.getArea(player.getLocation()).getDescription() + "\n");
                    io.simpleWrap(this.map.getArea(player.getLocation()).getDescription());
                }
                System.out.println();

            break;

            //gets list of enemies
            case "enemies":
                this.map.getArea(this.player.getLocation()).printEnemies();
            break;

            //gets list of exits
            case "exits":
                this.map.getArea(this.player.getLocation()).printExits();
            break;

            //gets list of objects
            case "objects":
                this.map.getArea(this.player.getLocation()).printObjects();
            break;

            //inspects object in room
            case "inspect":
                this.player.inspect(command.optionsAsString(), this.map);
            break;

            //attacks specified enemy
            case "attack":

                //makes sure target exists in area
                if(this.map.getArea(this.player.getLocation()).containsEnemy(command.optionsAsString())){

                    io.log("-Attacking: \n");
                    Scanner scnr = new Scanner(System.in);
                    String choice = "";
                    boolean run = false;
                    String enemyName = command.optionsAsString();
                    Actor enemy = this.map.getArea(this.player.getLocation()).getEnemy(enemyName);

                    System.out.println("Press \'a\' to attack");
                    System.out.println("Press \'r\' to run");
                    System.out.println();

                    //runs until player is dead or runs
                    while(!run && this.player.isAlive()){

                        //logs player and enemy names and health
                        io.log("\t-Player HP: " + this.player.getHP() + "\n");
                        System.out.println("Battle:");
                        System.out.println("Player HP: " + this.player.getHP());
                        io.log("\t-" + enemy.getName() + " HP: " + enemy.getHP() + "\n");
                        System.out.printf("%s HP: %d\n", enemy.getName(), enemy.getHP());

                        //if enemy is dead log that
                        //and then remove enemy from room
                        if(!enemy.isAlive()){
                            io.log("\t-" + enemy.getName() + " Dead!\n");
                            this.map.getArea(this.player.getLocation()).removeEnemy(enemy.getName());
                            break;
                        }

                        choice = scnr.nextLine();
                        System.out.println();

                        //battle controls
                        switch(choice){

                            //a to attack
                            case "a":
                                this.player.attack(enemy.getName(), this.map);
                                this.player.changeHP(-enemy.getAttackPower());
                            break;

                            //r to run
                            case "r":
                                System.out.println("Run Coward!");
                                run = true;
                            break;

                        }

                    }
                } else System.out.println("No Such Enemy");
            break;

            //will be added later
            //case "save":
            //    System.out.println("You chose save");
            //    io.save(command.getOption(0));
            //break;

            //case "load":
            //    System.out.println("You chose load");
            //    io.load(command.getOption(0));
            //break;

            //exits game
            case "leave":
                System.out.println("You chose exit");
                System.exit(0);
                break;

            //prints list of commands
            case "help":
                System.out.println("You chose help");
                System.out.println();
                System.out.println("-For list of exits: exits");
                System.out.println("-For list of enemies: enemies");
                System.out.println("-For list of objects: objects");
                System.out.println("-To inspect an object: inspect <object_name>");
                System.out.println("-To move to a new area: move <exit>");
                System.out.println("-To attack enemy: attack <enemy_name>");
                System.out.println("-To exit game: leave");
                //System.out.println("-To save game: save");
                //System.out.println("-To load game: load <file_name>");
                System.out.println("-To exit game: exit");
                break;

            case "NO_TYPE":
                System.out.printf("I don't know what \"%s\" is.", command.getOriginalText());
                break;

            default:
                System.out.println("Ya did it now");
                break;
        }
    }

    //for use of internal map outside of world object
    public Map getMap(){

        return this.map;
    }
}
