package net.htlgkr.groupK.chess.gamelogic;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.controller.ChessGameController;

import java.util.*;

public class MoveHandler
{
    private ChessGameController chessGameController;
    private Map<Index, Figure> tilesMap = new HashMap<>();
    private Label[][] tiles;

    public MoveHandler(ChessGameController chessGameController)
    {
        this.chessGameController = chessGameController;
    }

    public void move(Index fromIndex, Index toIndex, Figure figure)
    {
        
        //wenn der User die Figur auf das Feld setzen will wo sie sowieso schon steht ist der Move ungültig
        if(!fromIndex.equals(toIndex)) {
            if(figure.checkRequestedMove(fromIndex, toIndex)) {
                //TODO Überprüfung ob auf dem Weg eine Figur steht
                //remove Image from Tile on fromIndex and add image on Tile on toIndex
                tiles = chessGameController.getTiles();
                tiles[fromIndex.getX()][fromIndex.getY()].setGraphic(null);
                tiles[toIndex.getX()][toIndex.getY()].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(figure.getImagePath())).toString(), 75, 75, false, false)));

                //update entrys in tilesMap
                tilesMap = chessGameController.getTilesMap();
                tilesMap.put(toIndex, tilesMap.get(fromIndex));
                tilesMap.put(fromIndex, null);
            }else {
                System.out.println("bad move");
            }
        }else {
            System.out.println("bad move");
        }
    }
}