package net.htlgkr.groupK.chess;

import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {
    private CNT_loginPrompt CNT_loginPrompt;
    private final String CLIENTABBREVIATION = "[C]";
    private final String SERVERABBREVIATION = "[S]";

    private String userName;
    private int portNumber;
    private String password;

    public Server(CNT_loginPrompt CNT_loginPrompt) {
        this.CNT_loginPrompt = CNT_loginPrompt;
        getData();
    }

    public void getData() {
        StringBuilder incorrectDataStr = new StringBuilder();

        //Überprüfung user name
        if(CNT_loginPrompt.getTextField_createGame_userName().getText().equals("")) {
            incorrectDataStr.append("User name");
        }else {
            userName = CNT_loginPrompt.getTextField_createGame_userName().getText();
        }

        //Überprüfung port number
        try{
            portNumber = Integer.parseInt(CNT_loginPrompt.getTextField_createGame_portNumber().getText());
        }catch (Exception ex) {
            if(incorrectDataStr.toString().equals("")) {
                incorrectDataStr.append("Portnummer");
            }else {
                incorrectDataStr.append(", Portnummer");
            }
        }

        //Überprüfung password
        if(CNT_loginPrompt.getTextField_createGame_password().getText().equals("")) {
            if(incorrectDataStr.toString().equals("")) {
                incorrectDataStr.append("Passwort");
            }else {
                incorrectDataStr.append(", Passwort");
            }
        }else {
            password = CNT_loginPrompt.getTextField_createGame_password().getText();
        }

        //Überprüfung ob inkorrekte Daten vorliegen
        if(!incorrectDataStr.toString().equals("")) {
            incorrectDataStr.append(" inkorrekt.");
            CNT_loginPrompt.getText_createGame_incorrectData().setText(incorrectDataStr.toString());
            CNT_loginPrompt.getText_createGame_incorrectData().setVisible(true);
        }else {
            try {
                Main.createLoadingScreenServer((Stage) CNT_loginPrompt.getLoginPrompt_splitpane().getScene().getWindow());
            } catch (IOException e) {
                e.printStackTrace();
            }
            startListening();
        }
    }

    public void startListening() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(portNumber);
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("[Server] client connected");

                    BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

                    System.out.println("[Server] checking password");
                    if(br.readLine().equals(CLIENTABBREVIATION+password)) {
                        System.out.println("[Server] password correct");
                        Main.createChessGame((Stage) CNT_loginPrompt.getLoginPrompt_splitpane().getScene().getWindow());
                        System.out.println("[Server] chess game started");
                    }else {
                        System.out.println("[Server] password incorrect");
                        pw.println(SERVERABBREVIATION+"password incorrect");
                        clientSocket.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
