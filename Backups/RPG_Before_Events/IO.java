import java.io.*;

public class IO{

    private static String s;
    private static final int textWidth = 10;

    public IO(){

        this.s = "";

    }

    public void simpleWrap(String text){

        String[] splitText = text.split(" ");

        for(int i = 0; i < splitText.length; i++){

            if(i % textWidth == 0){
                System.out.printf("\n %s ", splitText[i]);
            }else{
                System.out.printf("%s ", splitText[i]);
            }
        }
    }

    public void save(String fileName){

        try{
            File outFile = new File(fileName);
            outFile.createNewFile();
            PrintWriter writer = new PrintWriter(fileName);
            writer.println("Test file");
            writer.println("test");
            writer.println("test");
            writer.println("test");
            writer.println("test");
            writer.close();
        }catch(IOException e){

        }
    }

    public String load(String fileName){

        String st = "";
        File file;
        BufferedReader br;

        try{
            file = new File(fileName);
            br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null)
                System.out.println(st);

        }catch(Exception e){


        }


        return st;

    }

}
