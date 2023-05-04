import java.util.*;

public class Command{

    private static final String[] validTypes = {"move", "details", "attack", "save", "load", "exit", "help"};
    private static String original;
    private static ArrayList<String> type;
    private static String sender;
    public static ArrayList<String> options;

    public Command(){
        this.original = "";
        this.type = new ArrayList<String>();
        this.type.add("NO_TYPE");
        this.options = new ArrayList<String>();
    }

    public String getOriginalText(){
        return original;
    }

    public String getType(){
        System.out.println(this.type.get(0));
        return this.type.get(0);
    }

    public String getOption(int n){

        if(this.options.size() > 0){
            return this.options.get(n);
        }else return "NO_OPTIONS";
    }

    public void printOptions(){

        System.out.print(options);
    }

    private boolean isValidType(String input){

        for(String s : validTypes)
            if(input.equals(s)) return true;
        return false;
    }

    public boolean process(String input){

        String[] splitInput = input.split(" ");
        this.original = input;
        this.type = new ArrayList<String>();
        this.type.add("NO_TYPE");
        this.options = new ArrayList<String>();

        if(splitInput.length != 0 && isValidType(splitInput[0])){

            if(splitInput.length > 1){
                this.type.set(0, splitInput[0]);
                for(int i = 1; i < splitInput.length; i++) this.options.add(splitInput[i]);
            }else this.type.set(0, splitInput[0]);
        }else return false;
        return true;
    }
}
