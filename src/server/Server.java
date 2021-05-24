/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author V5-561G
 */

public class Server {
    public void connect(){
        FileUtils fileUtils = new FileUtils("./textBot.txt");
        try {
            ArrayList<String> boxOfText = new ArrayList<String>();
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server is Listening...");
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true){
                String orginal = dataInputStream.readUTF();
                if(orginal.equals("over"))
                    break;
                String reverse = new StringBuilder(orginal).reverse().toString();
                dataOutputStream.writeUTF(reverse);
                boxOfText.add(orginal + " --> " + reverse);
                fileUtils.appendText(orginal + " --> " + reverse);
            }
            System.out.println("END");
            dataOutputStream.close();
            dataInputStream.close();
            serverSocket.close();
            socket.close();
            for (String str : boxOfText){
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println("Server failed");
            e.printStackTrace();
        }finally {
            fileUtils.close();
            System.out.println("Server closed");
        }
    }

}