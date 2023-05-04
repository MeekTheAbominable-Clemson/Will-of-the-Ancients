import java.util.*;

public class Menu{

    private static Scanner scnr =  new Scanner(System.in);
    public static String command;
    public static ArrayList<String> options;
    public static Command c;
    public static IO io;

    public Menu(){

        this.command = "";
        this.options = new ArrayList<String>();
    }

    public void menu(Command command, Map map, String currentRoom){



        boolean moveOn = false;

        System.out.println("Make a selection. For help type help:");

        do{

            System.out.println();
            System.out.print(command.getType() + " ");
            command.printOptions();
            System.out.println();
            System.out.println();
            System.out.print("> ");
            command.process(scnr.nextLine());

            switch(command.getType()){

            case "move":

                if(map.getArea(command.getOption(0)) != null){
                    currentRoom = command.getOption(0);
                } else {
                    System.out.println("No such Room!");
                }
                moveOn = true;
                break;

            case "details":
                map.getArea(currentRoom).printExits();
                continue;

            case "attack":
                System.out.println("You chose attack");
                moveOn = true;
                break;

            case "save":
                System.out.println("You chose save");
                break;

            case "exit":
                System.out.println("You chose exit");
                System.exit(0);
                break;

            case "help":
                System.out.println();
                System.out.println("You chose help");
                System.out.println("To move to a new area: move <exit>");
                System.out.println("To attack enemy: attack <enemy_name>");
                System.out.println("To save game: save");
                System.out.println("To exit game: exit");
                break;

            case "NO_TYPE":
                System.out.printf("I don't know what \"%s\" is.", command.getOriginalText());
                break;

            default:

                System.out.println("Ya done did it now!");
                break;
            }
        }while(!moveOn);
    }
}
