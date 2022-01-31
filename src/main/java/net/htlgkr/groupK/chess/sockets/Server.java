package net.htlgkr.groupK.chess.sockets;

import javafx.application.Platform;
import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.controller.LoginPromptController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {
    private LoginPromptController CNT_loginPrompt;
    private final String CLIENT_ABBREVIATION = "[C]";
    private final String SERVER_ABBREVIATION = "[S]";

    private String userName;
    private int portNumber;
    private String password;

    public Server(LoginPromptController CNT_loginPrompt) {
        this.CNT_loginPrompt = CNT_loginPrompt;
        getData();
    }

    private void getData() {
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
            if(portNumber >= 1 && portNumber <= 65535) {

            }else {
                throw new IllegalArgumentException();
            }
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
            CNT_loginPrompt.getText_createGame_ph_incorrectData().setText(incorrectDataStr.toString());
            CNT_loginPrompt.getText_createGame_ph_incorrectData().setVisible(true);
        }else {
            Platform.runLater(() -> {
                Main.createLoadingScreenServer(Main.stage);
            });
            startListening();
        }
    }

    public void startListening() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        ServerSocket serverSocket = new ServerSocket(portNumber);
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("[Server] client connected");

                        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

                        System.out.println("[Server] checking password");
                        if(br.readLine().equals(CLIENT_ABBREVIATION +password)) {
                            System.out.println("[Server] password correct");
                            pw.println(SERVER_ABBREVIATION +"password correct");
                            Platform.runLater(() -> {
                                Main.createChessGame(Main.stage);
                            });
                            System.out.println("[Server] chess game started");

                            //blockiert
                            br.readLine();
                        }else {
                            System.out.println("[Server] password incorrect");
                            pw.println(SERVER_ABBREVIATION +"password incorrect");
                            clientSocket.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                }
        }).start();
    }
    public String getUserName() {
        return userName;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public String getPassword() {
        return password;
    }
}
