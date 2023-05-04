import java.util.*;

public class Command{

    //list of valid commands
    private static final String[] validOptions = {"move", "objects", "inspect", "details", "exits", "enemies", "attack", "save", "load", "leave", "help"};
    public static String original;
    public static String type;
    public static ArrayList<String> options;

    public Command(){
        this.original = "";
        this.type = "NO_TYPE";
        this.options = new ArrayList<String>();
    }

    //gets original text from command line
    public String getOriginalText(){
        return original;
    }

    //gets the first valid word of command
    public String getType(){
        return this.type;
    }

    //gets a specific word after first valid word
    public String getOption(int n){

        if(this.options.size() > 0){
            return this.options.get(n);
        }else return "NO_OPTIONS";
    }

    //turns options into a string seperated by spaces
    public String optionsAsString(){

        String optionString = "";

        for(int i = 0; i < this.options.size(); i++){

            if(i == this.options.size() - 1){
                optionString += this.options.get(i);
            } else optionString += this.options.get(i) + " ";
        }
        return optionString;
    }

    //prints option
    public void printOptions(){

        System.out.print(options);
    }

    //checks if the string matches a listed type
    private boolean isValidType(String input){

        for(String s : validOptions)
            if(input.equals(s)) return true;
        return false;
    }

    //takes input and splits it in command type
    //and options for use in other game functions
    public boolean process(String input){

        String[] splitInput = input.split(" ");
        this.original = input;
        this.type = "NO_TYPE";
        this.options = new ArrayList<String>();

        //ensures first word is valid
        if(splitInput.length != 0 && isValidType(splitInput[0])){

            //splits first word into type and all other
            //words to spots in options list
            if(splitInput.length > 1){
                this.type = splitInput[0];
                for(int i = 1; i < splitInput.length; i++) this.options.add(splitInput[i]);
            }else this.type = splitInput[0];
        }else return false;
        return true;
    }

}
