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
    private static Menu menu;
    private static Command command;
    private static Scanner scnr;
    private static IO io;
    private static boolean debug;

    public static void main(String[] args) {

        io = new IO();
        debug = false;

        setupMap();
        setupPlayer();
        setupWorld();
        gameLoop();
    }

    static void setupMap(){

        map = new Map(){{
            addArea(new Area("Guest Room", "A room filled with numerous torture devices. Who said anything about welcome guests?"));
            addArea(new Area("Library", "Better version of the study. It has all of the different books that one may want. Make sure that you stay quiet or the mean librarian will slap you!"));
            addArea(new Area("Kitchen", "This amazing culinary art studio has it all: cheese cellar, wine racks, and a 16 stove burner. With its pizza oven, it makes for the perfect Italian getaway."));
            addArea(new Area("Study", "Do you love being disturbed while working? This room has it all. It is the central hub to the whole house. It has a giant wall of computers and amazing lighting, but doors that exit out into numerous different rooms."));
            addArea(new Area("Holodeck", "A room that can disguise itself in a variety of ways. Experience a lush, humid rainforest, a speakeasy of the 1920’s, or the dungeons of Cooper Library."));
            addArea(new Area("Trophy Room", "Spacious room with oak wood as far as the eye can see, shelves filled to the brim with trophies and obscure collections, it really makes you wonder who they belong to."));
            addArea(new Area("Bedroom", "A lavished bed adorns the center of this room, with long curtains, beautiful rugs, and gilded furniture acting as little details to truly make this a great bedroom."));

            getArea("Guest Room").addExit("Kitchen");
            getArea("Library").addExit("Holodeck");
            getArea("Library").addExit("Trophy Room");
            getArea("Library").addExit("Study");
            getArea("Kitchen").addExit("Study");
            getArea("Kitchen").addExit("Guest Room");
            getArea("Study").addExit("Kitchen");
            getArea("Study").addExit("Library");
            getArea("Study").addExit("Bedroom");
            getArea("Holodeck").addExit("Library");
            getArea("Trophy Room").addExit("Bedroom");
            getArea("Trophy Room").addExit("Library");
            getArea("Bedroom").addExit("Study");
            getArea("Bedroom").addExit("Trophy Room");
        }};
    }

    static void setupPlayer(){

        player = new Actor(100, "study");
    }

    static void setupWorld(){

        world = new World(map, player);
    }

    static Command broker(Command command){



    }

    static void gameLoop(){

        menu = new Menu();
        scnr = new Scanner(System.in);
        command = new Command();

        do{

            boolean updateWorld = false;
            io.simpleWrap(world.playerLocation().toString());
            System.out.println();

            do{
                if(debug){
                    System.out.println();
                    System.out.print(command.getType() + " ");
                    command.printOptions();
                }
                System.out.println();
                System.out.print("> ");
                command.process(scnr.nextLine());

                switch(command.getType()){

                case "move":
                    world.travelTo(command);
                    updateWorld = true;
                break;

                case "details":
                    System.out.println();
                    world.playerLocation().printExits();
                continue;

                case "attack":
                    System.out.println("You chose attack");
                    updateWorld = true;
                    break;

                case "save":
                    System.out.println("You chose save");
                    io.save(command.getOption(0));
                    break;

                case "load":
                    System.out.println("You chose load");
                    io.load(command.getOption(0));
                    break;

                case "exit":
                    System.out.println("You chose exit");
                    System.exit(0);
                    break;

                case "help":
                    System.out.println("You chose help");
                    System.out.println();
                    System.out.println("-To move to a new area: move <exit>");
                    System.out.println("-For more info about area: details");
                    System.out.println("-To attack enemy: attack <enemy_name>");
                    System.out.println("-To save game: save");
                    System.out.println("-To load game: load <file_name>");
                    System.out.println("-To exit game: exit");
                    break;

                case "NO_TYPE":
                    System.out.printf("I don't know what \"%s\" is.", command.getOriginalText());
                    break;

                default:

                    System.out.println("Ya done did it now!");
                    break;
                }
            }while(!updateWorld);
        }while(true);
    }
}
