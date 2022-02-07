package net.htlgkr.groupK.chess;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Frame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class CommandWriter {
    private final String CLIENT_ABBREVIATION = "[C]";
    private final String SERVER_ABBREVIATION = "[S]";
    private Socket socket;

    public CommandWriter() {
        socket = Main.isServer ? Main.server.getClientSocket() : Main.client.getSocket();
    }

    public void sendFrame(Frame frame) {
        try {
            if(Main.isServer) {
                Main.server.getOos().writeObject(frame);
                Main.server.getOos().flush();
            }else {
                Main.client.getOos().writeObject(frame);
                Main.client.getOos().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
