package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket socket;
    private FileUtils fileUtils;
    private int index;

    public ClientHandler(Socket socket, FileUtils fileUtils, int index){
        this.socket = socket;
        this.fileUtils = fileUtils;
        this.index = index;
        System.out.println("Client " + index + " connected!");
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true){
                String original = dataInputStream.readUTF();
                if(original.equals("over"))
                    break;
                String reverse = new StringBuilder(original).reverse().toString();
                dataOutputStream.writeUTF(reverse);
                fileUtils.appendText("Cleint-" + index + ":" + original + " --> " + reverse);
            }
            System.out.println("END");
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println("Client " + index + " - Failed: " + e.getMessage());
        }

    }


}
