package net.htlgkr.groupK.chess.sockets;

import javafx.application.Platform;
import net.htlgkr.groupK.chess.Data;
import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.controller.LoginPromptController;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    private LoginPromptController loginPromptController;
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

    public Client(LoginPromptController loginPromptController) {
        this.loginPromptController = loginPromptController;
        getData();
    }

    public void getData() {
        StringBuilder incorrectDataStr = new StringBuilder();

        //Überprüfung user name
        if(loginPromptController.getTextField_joinGame_userName().getText().equals("")) {
            incorrectDataStr.append("User name");
        }else {
            userName = loginPromptController.getTextField_joinGame_userName().getText();
        }

        //Überprüfung ip address
        if(loginPromptController.getTextField_joinGame_ipAddress().getText().equals("")) {
                if(incorrectDataStr.toString().equals("")) {
                    incorrectDataStr.append("IP-Adresse");
                }else {
                    incorrectDataStr.append(", IP-Adresse");
                }
        }else {
            if(loginPromptController.getTextField_joinGame_ipAddress().getText().equals("localhost")) {
                ipAddress = loginPromptController.getTextField_joinGame_ipAddress().getText();
            }else {
                try {
                    String[] parts = loginPromptController.getTextField_joinGame_ipAddress().getText().split("\\.");
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
                            ipAddress = loginPromptController.getTextField_joinGame_ipAddress().getText();
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
            portNumber = Integer.parseInt(loginPromptController.getTextField_joinGame_portNumber().getText());
        }catch (Exception ex) {
            if(incorrectDataStr.toString().equals("")) {
                incorrectDataStr.append("Portnummer");
            }else {
                incorrectDataStr.append(", Portnummer");
            }
        }

        //Überprüfung password
        if(loginPromptController.getTextField_joinGame_password().getText().equals("")) {
            if(incorrectDataStr.toString().equals("")) {
                incorrectDataStr.append("Passwort");
            }else {
                incorrectDataStr.append(", Passwort");
            }
        }else {
            password = loginPromptController.getTextField_joinGame_password().getText();
        }

        //Überprüfung ob inkorrekte Daten vorliegen
        if(!incorrectDataStr.toString().equals("")) {
            incorrectDataStr.append(" inkorrekt.");
            loginPromptController.getText_joinGame_ph_incorrectData().setText(incorrectDataStr.toString());
            loginPromptController.getText_joinGame_ph_incorrectData().setVisible(true);
        }else {
            address = new InetSocketAddress(ipAddress, portNumber);

            Main.dataFromClient = new Data(userName, password, ipAddress, portNumber);

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
                    socket.connect(address, 5000);  //TODO timeout wenn Client versucht 2 mal auf Server zu connecten
                    System.out.println(CLIENT_ABBREVIATION + "client connected");

                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    pw = new PrintWriter(socket.getOutputStream(), true);
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    ois = new ObjectInputStream(socket.getInputStream());

                    //Client sendet seine Data Klasse an Server
                    oos.writeObject(Main.dataFromClient);
                    oos.flush();

                    //Client liest Data Klasse von Server ein und speichert sie
                    Main.dataFromServer = (Data) ois.readObject();

                    if(br.readLine().equals(SERVER_ABBREVIATION +"password incorrect")) {
                        Platform.runLater(() -> {
                            Main.createPasswordIncorrectScreenClient(Main.stage);
                        });
                    }else {
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
