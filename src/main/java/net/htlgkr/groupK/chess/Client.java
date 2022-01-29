package net.htlgkr.groupK.chess;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private UI_LoginPrompt_Controller ui_loginPrompt_cnt;
    private InetSocketAddress address;

    public Client(UI_LoginPrompt_Controller ui_loginPrompt_cnt) {
        this.ui_loginPrompt_cnt = ui_loginPrompt_cnt;
        address = new InetSocketAddress(ui_loginPrompt_cnt.getIdIPAddress().getText(),
                Integer.parseInt(ui_loginPrompt_cnt.getIdPortNumber().getText()));
    }


    public void startClient() {
        try {
            Socket socket = new Socket();
            socket.connect(address);
            System.out.println("[Client] client connected");

            System.out.println("[Client] client closed");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
