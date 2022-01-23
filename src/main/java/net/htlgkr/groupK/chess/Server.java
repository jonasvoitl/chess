package net.htlgkr.groupK.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("[Server] enter port");
        Scanner s = new Scanner(System.in);
        int port = Integer.parseInt(s.nextLine());

        Server server = new Server(port);
        System.out.println("[Server] server started");
        server.startListening();
    }

    public void startListening() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(port);
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("[Server] client connected");

                    Scanner s = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
                    if(s.hasNextLine()) {
                        System.out.println("[Server] message from client: " + s.nextLine());
                    }

                    s.close();
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
