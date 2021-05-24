/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author V5-561G
 */
public class Client {
    public void connect(){
        try {
            Socket socket = new Socket("localhost",8000);
            Scanner scanner = new Scanner(System.in);
            String input;
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true){
                input = scanner.nextLine();
                if(input.equals("over")){
                    dataOutputStream.writeUTF("over");
                    break;
                }
                dataOutputStream.writeUTF(input);
                System.out.println(dataInputStream.readUTF()+"");
            }
            socket.close();
            dataInputStream.close();
            dataOutputStream.close();
        } catch (IOException e) {
            System.out.println("Client failed to connect!");
//            e.printStackTrace();
        }finally {
            System.out.println("Client closed!");
        }
    }








}