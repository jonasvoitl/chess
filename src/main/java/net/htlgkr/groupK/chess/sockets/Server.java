package net.htlgkr.groupK.chess.sockets;

import javafx.application.Platform;
import net.htlgkr.groupK.chess.CommandReader;
import net.htlgkr.groupK.chess.Data;
import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.controller.LoginPromptController;

import java.io.*;
import java.net.*;

public class Server {
    private LoginPromptController loginPromptController;
    private final String CLIENT_ABBREVIATION = "[C]";
    private final String SERVER_ABBREVIATION = "[S]";
    private BufferedReader br;
    private PrintWriter pw;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private CommandReader commandReader;
    private boolean isConnected = false;

    private String userName;
    private String password;
    private int portNumber;

    public Server(LoginPromptController loginPromptController) {
        this.loginPromptController = loginPromptController;
        getData();
    }

    private void getData() {
        StringBuilder incorrectDataStr = new StringBuilder();

        //Überprüfung user name
        if(loginPromptController.getTextField_createGame_userName().getText().equals("")) {
            incorrectDataStr.append("User name");
        }else {
            userName = loginPromptController.getTextField_createGame_userName().getText();
        }

        //Überprüfung port number
        try{
            portNumber = Integer.parseInt(loginPromptController.getTextField_createGame_portNumber().getText());
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
        if(loginPromptController.getTextField_createGame_password().getText().equals("")) {
            if(incorrectDataStr.toString().equals("")) {
                incorrectDataStr.append("Passwort");
            }else {
                incorrectDataStr.append(", Passwort");
            }
        }else {
            password = loginPromptController.getTextField_createGame_password().getText();
        }

        //Überprüfung ob inkorrekte Daten vorliegen
        if(!incorrectDataStr.toString().equals("")) {
            incorrectDataStr.append(" inkorrekt.");
            loginPromptController.getText_createGame_ph_incorrectData().setText(incorrectDataStr.toString());
            loginPromptController.getText_createGame_ph_incorrectData().setVisible(true);
        }else {
                Main.dataFromServer = new Data();
                Main.dataFromServer.setUserName(userName);
                Main.dataFromServer.setPassword(password);
                Main.dataFromServer.setPortNumber(portNumber);

                Main.isServer = true;

                Platform.runLater(() -> {
                    Main.createLoadingScreenServer(Main.stage);
                });

            try {
                serverSocket = new ServerSocket(portNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(SERVER_ABBREVIATION + "new serverSocket created");
            startListening();
        }
    }

    public void startListening() {
        System.out.println(SERVER_ABBREVIATION + "start listening");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        clientSocket = serverSocket.accept();
                        if(isConnected) {
                            clientSocket.close();
                            continue;
                        }
                        System.out.println(SERVER_ABBREVIATION + "client connected");

                        br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        pw = new PrintWriter(clientSocket.getOutputStream(), true);
                        oos = new ObjectOutputStream(clientSocket.getOutputStream());
                        ois = new ObjectInputStream(clientSocket.getInputStream());

                        //Server sendet seine Data Klasse an Client
                        oos.writeObject(Main.dataFromServer);
                        oos.flush();

                        //Server liest Data Klasse von Client ein und speichert sie
                        Main.dataFromClient = (Data) ois.readObject();

                        System.out.println(SERVER_ABBREVIATION + "checking password");
                        if(Main.dataFromClient.getPassword().equals(password)) {
                            System.out.println(SERVER_ABBREVIATION + "password correct");
                            pw.println(SERVER_ABBREVIATION +"password correct");

                            new Thread(commandReader = new CommandReader(clientSocket)).start();

                            Platform.runLater(() -> {
                                Main.createChessGame(Main.stage);
                            });
                            System.out.println(SERVER_ABBREVIATION + "chess game started");
                            isConnected = true;
                        }else {
                            System.out.println(SERVER_ABBREVIATION + "password incorrect");
                            pw.println(SERVER_ABBREVIATION +"password incorrect");
                            clientSocket.close();
                        }
                        System.out.println(SERVER_ABBREVIATION + "reached end of code");
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

    public Socket getClientSocket() {
        return clientSocket;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public ObjectInputStream getOis() {
        return ois;
    }
}
