/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    private FileUtils fileUtils;

    public Server(){
        fileUtils = new FileUtils("./textBox.txt");
    }

    public void run(){
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server is Listening...");
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
            for (int i = 0; i < 10; i++){
                try {
                    Socket socket = serverSocket.accept();
                    threadPoolExecutor.execute(new ClientHandler(socket, fileUtils, i));
                }catch (Exception e){
                    System.out.println("Failed to accept: " + e.getMessage());
                }
            }
            threadPoolExecutor.shutdown();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Server failed: " + e.getMessage());
        } finally {
            fileUtils.close();
            System.out.println("Server closed");
        }
    }

}