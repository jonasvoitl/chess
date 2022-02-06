package net.htlgkr.groupK.chess.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.figures.*;
import net.htlgkr.groupK.chess.Main;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChessGameController implements Initializable
{
    private List<Figure> orangeFigures = new ArrayList<>();
    private List<Figure> blueFigures = new ArrayList<>();
    private Label[][] tiles;

    @FXML
    public GridPane GP_backgroundChessBoard;

    @FXML
    public Label text_userName_blue;

    @FXML
    public Label text_userName_orange;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        createTiles();
        setStartingPositions();

        Platform.runLater(() -> {
            this.text_userName_blue.setText(Main.dataFromServer.getUserName());
            this.text_userName_orange.setText(Main.dataFromClient.getUserName());
        });
    }

    private void createTiles()
    {
        tiles = new Label[8][8];

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                Label tile = new Label();
                tile.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

                if(i % 2 == 0)
                {
                    if(j % 2 == 0)
                    {
                        tile.setStyle("-fx-background-color: #FFFFFF");
                    }
                    else
                    {
                        tile.setStyle("-fx-background-color: #000000");
                    }
                }
                else
                {
                    if(j % 2 == 0)
                    {
                        tile.setStyle("-fx-background-color: #000000");
                    }
                    else
                    {
                        tile.setStyle("-fx-background-color: #FFFFFF");
                    }
                }

                tiles[i][j] = tile;
                GP_backgroundChessBoard.add(tile, i, j);
            }
        }
    }

    private void setStartingPositions()
    {
        //Setup for Orange-Team
        orangeFigures.add(new Rook(false, tiles[0][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/rook_orange.png")).toString(), 75, 75, false, false))));
        orangeFigures.add(new Knight(false, tiles[1][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/knight_orange.png")).toString(), 75, 75, false, false))));
        orangeFigures.add(new Bishop(false, tiles[2][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/bishop_orange.png")).toString(), 75, 75, false, false))));
        orangeFigures.add(new King(false, tiles[3][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/king_orange.png")).toString(), 75, 75, false, false))));
        orangeFigures.add(new Queen(false, tiles[4][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/queen_orange.png")).toString(), 75, 75, false, false))));
        orangeFigures.add(new Bishop(false, tiles[5][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/bishop_orange.png")).toString(), 75, 75, false, false))));
        orangeFigures.add(new Knight(false, tiles[6][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/knight_orange.png")).toString(), 75, 75, false, false))));
        orangeFigures.add(new Rook(false, tiles[7][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/rook_orange.png")).toString(), 75, 75, false, false))));

        for (int i = 0; i < 8; i++)
        {
            orangeFigures.add(new Pawn(false, tiles[i][1], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_orange.png")).toString(), 75, 75, false, false))));
        }

        //Setup for Blue-Team
        blueFigures.add(new Rook(true, tiles[0][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/blue/rook_blue.png")).toString(), 75, 75, false, false))));
        blueFigures.add(new Knight(true, tiles[1][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/blue/knight_blue.png")).toString(), 75, 75, false, false))));
        blueFigures.add(new Bishop(true, tiles[2][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/blue/bishop_blue.png")).toString(), 75, 75, false, false))));
        blueFigures.add(new King(true, tiles[3][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/blue/king_blue.png")).toString(), 75, 75, false, false))));
        blueFigures.add(new Queen(true, tiles[4][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/blue/queen_blue.png")).toString(), 75, 75, false, false))));
        blueFigures.add(new Bishop(true, tiles[5][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/blue/bishop_blue.png")).toString(), 75, 75, false, false))));
        blueFigures.add(new Knight(true, tiles[6][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/blue/knight_blue.png")).toString(), 75, 75, false, false))));
        blueFigures.add(new Rook(true, tiles[7][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/blue/rook_blue.png")).toString(), 75, 75, false, false))));

        for (int i = 0; i < 8; i++)
        {
            blueFigures.add(new Pawn(true, tiles[i][6], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/blue/pawn_blue.png")).toString(), 75, 75, false, false))));
        }
    }
}