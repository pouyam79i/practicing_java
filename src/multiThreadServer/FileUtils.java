package server;

import java.io.*;

/**
 * Class of FileUtils
 * This contains function which handles io of this application
 * @author Pouya Mohammadi - Uni ID: 9829039
 */
public class FileUtils{

    private FileWriter fw;
    private BufferedWriter bw;
    private PrintWriter pw;

    public FileUtils(String address){
        System.out.println("File utils initialized!");
        try {
            fw = new FileWriter(address, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
        }catch (Exception e){
            System.out.println("Failed to print to the file");
            fw = null;
        }
    }

    public synchronized void appendText(String text){
        try {
            if(fw == null){
                System.out.println("File is not opened");
                return;
            }
            pw.println(text);
            pw.flush();
            System.out.println("Data appended");
        }catch (Exception e){
            System.out.println("Failed to write anything: " + e.getMessage());
        }
    }

    public void close(){
        try {
            if(pw != null )
                pw.close();
            if(bw != null )
                bw.close();
            if(fw != null )
                fw.close();
        }catch (Exception e){
            System.out.println("Closing File Failed: " + e.getMessage());
        }finally {
            System.out.println("File closed");
        }
    }

}
