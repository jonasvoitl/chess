package net.htlgkr.groupK.chess;

import java.net.Socket;

public class CommandReader implements Runnable{
    private final String CLIENT_ABBREVIATION = "[C]";
    private final String SERVER_ABBREVIATION = "[S]";
    private Socket clientSocket;

    public CommandReader(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

    }
}
