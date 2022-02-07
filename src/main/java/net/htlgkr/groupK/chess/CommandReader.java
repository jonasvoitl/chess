package net.htlgkr.groupK.chess;

import eu.hansolo.tilesfx.Tile;
import javafx.application.Platform;
import javafx.scene.control.Label;
import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Frame;
import net.htlgkr.groupK.chess.gamelogic.Index;
import net.htlgkr.groupK.chess.gamelogic.MoveHandler;
import net.htlgkr.groupK.chess.gamelogic.figures.King;
import net.htlgkr.groupK.chess.gamelogic.figures.Pawn;

import java.io.*;
import java.net.Socket;

public class CommandReader implements Runnable{
    private final String CLIENT_ABBREVIATION = "[C]";
    private final String SERVER_ABBREVIATION = "[S]";
    private BufferedReader br;
    private ObjectInputStream ois;
    private Socket socket;

    public CommandReader(Socket clientSocket) {
        this.socket = clientSocket;
        if(Main.isServer) {
            ois = Main.server.getOis();
        }else {
            ois = Main.client.getOis();
        }
    }

    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true) {
                    Frame frame = (Frame) ois.readObject();

                    Platform.runLater(() -> {
                        Figure figure = Main.chessGameController.getTilesMap().get(frame.getToIndex());

                        boolean moveValid = Main.moveHandler.move(frame.getFromIndex(), frame.getToIndex(), frame.getFigure());
                        if(moveValid && frame.getFigure() instanceof Pawn pawn) {
                            pawn.setFirstPawnMove(false);
                        }

                        if(moveValid && figure instanceof King) {
                            if(Main.isServer) {
                                Main.createLoosingScreenServer(Main.stage);
                            }else {
                                Main.createLoosingScreenClient(Main.stage);
                            }
                        }
                    });
                }
            } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
