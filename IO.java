import java.io.*;
import java.nio.file.Files;

public class IO{

    private static String s;
    private static File outLog;
    private static FileOutputStream fos;
    private static final int textWidth = 10;

    public IO(){

        this.s = "";
        outLog = null;
    }

    public IO(String logFileName){

        this.s = "";

        //sets up and creates specified file
        //sets name to logFileName
        try{
            outLog = new File(logFileName);
            outLog.createNewFile();
        }catch(IOException e){


        }

    }

    //appends string toWrite to specified log file
    public void log(String toWrite){

        try {
            FileWriter fw = new FileWriter(outLog, true);
            fw.write(toWrite);
            fw.close();
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    //wraps text to make it easier to read
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

    //public void save(String fileName){

    //    try{
    //        File outFile = new File(fileName);
    //        outFile.createNewFile();
    //        PrintWriter writer = new PrintWriter(fileName);
    //        writer.println("Test file");
    //        writer.println("test");
    //        writer.println("test");
    //        writer.println("test");
    //        writer.println("test");
    //        writer.close();
    //    }catch(IOException e){

    //    }
    //}

    //public String load(String fileName){

    //    String st = "";
    //    File file;
    //    BufferedReader br;

    //    try{
    //        file = new File(fileName);
    //        br = new BufferedReader(new FileReader(file));

    //        while ((st = br.readLine()) != null)
    //            System.out.println(st);

    //    }catch(Exception e){


    //    }


    //    return st;

    //}

}
