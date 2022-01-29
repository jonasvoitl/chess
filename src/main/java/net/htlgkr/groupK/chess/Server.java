package net.htlgkr.groupK.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class Server {
    private UI_LoginPrompt_Controller ui_loginPrompt_cnt;

    public Server(UI_LoginPrompt_Controller ui_loginPrompt_cnt) {
        this.ui_loginPrompt_cnt = ui_loginPrompt_cnt;
    }

    public void startListening() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(4802);
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("[Server] client connected");

                    System.out.println("[Server] client password: " + ui_loginPrompt_cnt.getIdUserPassword().getText());

                    clientSocket.close();
                    System.out.println("[Server] server closed");
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
