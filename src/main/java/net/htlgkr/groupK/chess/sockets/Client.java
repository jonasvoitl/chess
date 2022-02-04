package net.htlgkr.groupK.chess.sockets;

import javafx.application.Platform;
import net.htlgkr.groupK.chess.Data;
import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.controller.LoginPromptController;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    private LoginPromptController CNT_loginPrompt;
    private InetSocketAddress address;
    private final String CLIENT_ABBREVIATION = "[C]";
    private final String SERVER_ABBREVIATION = "[S]";
    private BufferedReader br;
    private PrintWriter pw;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private String userName;
    private String ipAddress;
    private int portNumber;
    private String password;

    public Client(LoginPromptController CNT_loginPrompt) {
        this.CNT_loginPrompt = CNT_loginPrompt;
        getData();
    }

    public void getData() {
        StringBuilder incorrectDataStr = new StringBuilder();

        //Überprüfung user name
        if(CNT_loginPrompt.getTextField_joinGame_userName().getText().equals("")) {
            incorrectDataStr.append("User name");
        }else {
            userName = CNT_loginPrompt.getTextField_joinGame_userName().getText();
        }

        //Überprüfung ip address
        if(CNT_loginPrompt.getTextField_joinGame_ipAddress().getText().equals("")) {
                if(incorrectDataStr.toString().equals("")) {
                    incorrectDataStr.append("IP-Adresse");
                }else {
                    incorrectDataStr.append(", IP-Adresse");
                }
        }else {
            if(CNT_loginPrompt.getTextField_joinGame_ipAddress().getText().equals("localhost")) {
                ipAddress = CNT_loginPrompt.getTextField_joinGame_ipAddress().getText();
            }else {
                try {
                    String[] parts = CNT_loginPrompt.getTextField_joinGame_ipAddress().getText().split("\\.");
                    if (parts.length==4) {
                        for(int i=0; i<parts.length; i++) {
                            if(Integer.parseInt(parts[i])>=0&&Integer.parseInt(parts[i])<=255) {

                            }else {
                                if(incorrectDataStr.toString().equals("")) {
                                    incorrectDataStr.append("IP-Adresse");
                                }else {
                                    incorrectDataStr.append(", IP-Adresse");
                                }
                                break;
                            }
                            ipAddress = CNT_loginPrompt.getTextField_joinGame_ipAddress().getText();
                        }
                    }else {
                        if(incorrectDataStr.toString().equals("")) {
                            incorrectDataStr.append("IP-Adresse");
                        }else {
                            incorrectDataStr.append(", IP-Adresse");
                        }
                    }
                }catch (Exception ex) {
                    if(incorrectDataStr.toString().equals("")) {
                        incorrectDataStr.append("IP-Adresse");
                    }else {
                        incorrectDataStr.append(", IP-Adresse");
                    }
                }
            }
        }

        //Überprüfung port number
        try{
            portNumber = Integer.parseInt(CNT_loginPrompt.getTextField_joinGame_portNumber().getText());
        }catch (Exception ex) {
            if(incorrectDataStr.toString().equals("")) {
                incorrectDataStr.append("Portnummer");
            }else {
                incorrectDataStr.append(", Portnummer");
            }
        }

        //Überprüfung password
        if(CNT_loginPrompt.getTextField_joinGame_password().getText().equals("")) {
            if(incorrectDataStr.toString().equals("")) {
                incorrectDataStr.append("Passwort");
            }else {
                incorrectDataStr.append(", Passwort");
            }
        }else {
            password = CNT_loginPrompt.getTextField_joinGame_password().getText();
        }

        //Überprüfung ob inkorrekte Daten vorliegen
        if(!incorrectDataStr.toString().equals("")) {
            incorrectDataStr.append(" inkorrekt.");
            CNT_loginPrompt.getText_joinGame_ph_incorrectData().setText(incorrectDataStr.toString());
            CNT_loginPrompt.getText_joinGame_ph_incorrectData().setVisible(true);
        }else {
            address = new InetSocketAddress(ipAddress, portNumber);

            Main.dataFromClient = new Data();
            Main.dataFromClient.setUserName(userName);
            Main.dataFromClient.setPassword(password);

            Main.createLoadingScreenClient(Main.stage);
            startClient();
        }
    }

    public void startClient() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket();
                    socket.connect(address, 5000);
                    System.out.println("[Client] client connected");

                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    pw = new PrintWriter(socket.getOutputStream(), true);
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    ois = new ObjectInputStream(socket.getInputStream());

                    //Anfrage an Server mit Passwort senden
                    pw.println(CLIENT_ABBREVIATION +password);

                    if(br.readLine().equals(SERVER_ABBREVIATION +"password incorrect")) {
                        Platform.runLater(() -> {
                            Main.createPasswordIncorrectScreenClient(Main.stage);
                        });
                    }else {
                        //Client sendet seine Data Klasse an Server
                        oos.writeObject(Main.dataFromClient);

                        //Client liest Data Klasse von Server ein und speichert sie
                        Main.dataFromServer = (Data) ois.readObject();

                        Platform.runLater(() -> {
                            Main.createChessGame(Main.stage);
                        });
                    }
                } catch (Exception e) {
                    Platform.runLater(() -> {
                        Main.createConnectionFailedClient(Main.stage);
                    });
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public String getUserName() {
        return userName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public String getPassword() {
        return password;
    }

    private void sendClientInstanceToServer() {

    }
}
