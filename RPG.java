/*
    Michael Brumbaugh
    CPSC 1060: RPG
    2/3/2023
*/

import java.util.*;

public class RPG {

    private static World world;
    private static Map map;
    private static Actor player;
    private static Command command;
    private static Scanner scnr;
    private static IO io;
    private static boolean debug;
    private static final ArrayList<String> title = new ArrayList<String>();

    public static void main(String[] args) {

        //Adds title of ascii title line by line to array list
        //for easy printing
        title.add("         _________ _        _          _______  _______   _________          _______    _______  _        _______ _________ _______  _       _________ _______  _");
        title.add("|\\     /|\\__   __/( \\      ( \\        (  ___  )(  ____ \\  \\__   __/|\\     /|(  ____ \\  (  ___  )( (    /|(  ____ \\\\__   __/(  ____ \\( (    /|\\__   __/(  ____ \\( )");
        title.add("| )   ( |   ) (   | (      | (        | (   ) || (    \\/     ) (   | )   ( || (    \\/  | (   ) ||  \\  ( || (    \\/   ) (   | (    \\/|  \\  ( |   ) (   | (    \\/| |");
        title.add("| | _ | |   | |   | |      | |        | |   | || (__         | |   | (___) || (__      | (___) ||   \\ | || |         | |   | (__    |   \\ | |   | |   | (_____ | |");
        title.add("| |( )| |   | |   | |      | |        | |   | ||  __)        | |   |  ___  ||  __)     |  ___  || (\\ \\) || |         | |   |  __)   | (\\ \\) |   | |   (_____  )| |");
        title.add("| || || |   | |   | |      | |        | |   | || (           | |   | (   ) || (        | (   ) || | \\   || |         | |   | (      | | \\   |   | |         ) |(_)");
        title.add("| () () |___) (___| (____/\\| (____/\\  | (___) || )           | |   | )   ( || (____/\\  | )   ( || )  \\  || (____/\\___) (___| (____/\\| )  \\  |   | |   /\\____) | _");
        title.add("(_______)\\_______/(_______/(_______/  (_______)|/            )_(   |/     \\|(_______/  |/     \\||/    )_)(_______/\\_______/(_______/|/    )_)   )_(   \\_______)(_)");

        //instantiates now IO object for logging
        io = new IO("log.txt");
        io.log("\n\n");
        io.log("-New Game Started\n");
        //shows additional info if true
        debug = false;

        setupMap();
        setupPlayer();
        setupWorld();
        gameLoop();
    }

    static void setupMap(){

        //creates now map
        map = new Map();

        //adds area Tower and
        map.addArea(new Area("Tower", "In front of you stands a great tower of black marble lined with rows of windows closed to the outside by iron bars."), io);
        map.getArea("Tower").addExit("Tower: First Floor", io);
        map.getArea("Tower").addExit("Woods", io);

        //adds area Tower: first floor exits and an enemy
        map.addArea(new Area("Tower: First Floor", "A place tinged with blood."), io);
        map.getArea("Tower: First Floor").addExit("Tower", io);
        map.getArea("Tower: First Floor").addEnemy(new Actor(100, 2, "rat", "Tower: First Floor"), io);

        //adds area Woods exits an enemy and an object
        map.addArea(new Area("Woods", "An ancient woodland. These woods are home to many a wimsical beast, but beware the fairies! This land is ruled by Oona the greatest fairy of them all. Her wraths is exceeded only by her beauty."), io);
        map.getArea("Woods").addExit("Tower", io);
        map.getArea("Woods").addExit("Font", io);
        map.getArea("Woods").addEnemy(new Actor(100, 4, "fairy", "Woods"), io);
        map.getArea("Woods").addObject("stick", "Nothing remarkable here.", io);

        //adds area Font exits and an object
        map.addArea(new Area("Font", "This mysterious structure has been around longer than anyone can remember. There seems to be a faint ringing eminating from it."), io);
        map.getArea("Font").addExit("Woods", io);
        map.getArea("Font").addObject("floop", "On closer inspection you can see that the font is lined with many ancient runes.", io);
    }

    //sets up player can be extended for customization
    static void setupPlayer(){

        player = new Actor(100, 10, "Player", "Tower");
    }

    //sets up world can be extended for further customization
    static void setupWorld(){

        world = new World(map, player, io);
    }

    //The game begins
    static void gameLoop(){

        scnr = new Scanner(System.in);
        command = new Command();

        //prints intro and title
        System.out.println();
        System.out.println("Welcome to:");
        for(int i = 0; i < title.size(); i++){

            System.out.println(title.get(i));
        }

        System.out.println();
        System.out.println("-For list of exits: exits");
        System.out.println("-For list of enemies: enemies");
        System.out.println("-For list of objects: objects");
        System.out.println("-To inspect an object: inspect <object_name>");
        System.out.println("-To move to a new area: move <exit>");
        System.out.println("-To attack enemy: attack <enemy_name>");
        System.out.println("-To exit game: leave");
        System.out.println("-To exit game: exit");
        System.out.println();
        System.out.println("Type \"help\" to reprint the above list");
        System.out.println();


        do{

            //prints initial location and description
            System.out.println(player.getLocation() + ":");
            io.simpleWrap(world.getMap().getArea(player.getLocation()).getDescription());
            System.out.println();

            do{
                if(debug){
                    System.out.println();
                    System.out.print(command.getType() + " ");
                    command.printOptions();
                }
                //prints prompt arrow (>)
                System.out.println();
                System.out.println("World:");
                System.out.print("> ");
                //takes user input
                command.process(scnr.nextLine());

                //command passed here actual game logic
                world.action(command);

            //loop ends if player health is zero
            }while(player.isAlive());

            System.out.println("You died!");

        }while(true);
    }
}
