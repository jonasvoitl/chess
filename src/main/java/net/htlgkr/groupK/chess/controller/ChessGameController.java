package net.htlgkr.groupK.chess.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import net.htlgkr.groupK.chess.GameLogic.Figures.*;
import net.htlgkr.groupK.chess.Main;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChessGameController implements Initializable
{
    private Label[][] tiles;

    private Rook rookOrange1;
    private Knight knightOrange1;
    private Bishop bishopOrange1;
    private King kingOrange;
    private Queen queenOrange;
    private Bishop bishopOrange2;
    private Knight knightOrange2;
    private Rook rookOrange2;
    private Pawn pawnOrange1;
    private Pawn pawnOrange2;
    private Pawn pawnOrange3;
    private Pawn pawnOrange4;
    private Pawn pawnOrange5;
    private Pawn pawnOrange6;
    private Pawn pawnOrange7;
    private Pawn pawnOrange8;

    private Rook rookBlue1;
    private Knight knightBlue1;
    private Bishop bishopBlue1;
    private King kingBlue;
    private Queen queenBlue;
    private Bishop bishopBlue2;
    private Knight knightBlue2;
    private Rook rookBlue2;
    private Pawn pawnBlue1;
    private Pawn pawnBlue2;
    private Pawn pawnBlue3;
    private Pawn pawnBlue4;
    private Pawn pawnBlue5;
    private Pawn pawnBlue6;
    private Pawn pawnBlue7;
    private Pawn pawnBlue8;

    @FXML
    public GridPane GP_chessBoard;

    @FXML
    public Label text_userName_blue;

    @FXML
    public Label text_userName_orange;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        makeTiles();
        setupStartingPositions();

        Platform.runLater(() -> {
            this.text_userName_blue.setText(Main.dataFromServer.getUserName());
            this.text_userName_orange.setText(Main.dataFromClient.getUserName());
        });
    }

    private void makeTiles()
    {
        tiles = new Label[8][8];

        for (Node child : GP_chessBoard.getChildren())
        {
            Label tile = (Label) child;
            tiles[GridPane.getColumnIndex(child)][GridPane.getRowIndex(child)] = tile;
            tile.setGraphic(new ImageView());
        }
    }

    private void setupStartingPositions()
    {
        //Setup for Orange-Team
        rookOrange1 = new Rook(false, tiles[0][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/rook_orange.png")).toString())));
        knightOrange1 = new Knight(false, tiles[0][1], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/knight_orange.png")).toString())));
        bishopOrange1 = new Bishop(false, tiles[0][2], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/bishop_orange.png")).toString())));
        kingOrange = new King(false, tiles[0][3], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/king_orange.png")).toString())));
        queenOrange = new Queen(false, tiles[0][4], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/queen_orange.png")).toString())));
        bishopOrange2 = new Bishop(false, tiles[0][5], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/bishop_orange.png")).toString())));
        knightOrange2 = new Knight(false, tiles[0][6], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/knight_orange.png")).toString())));
        rookOrange2 = new Rook(false, tiles[0][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/rook_orange.png")).toString())));
        pawnOrange1 = new Pawn(false, tiles[1][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_orange.png")).toString())));
        pawnOrange2 = new Pawn(false, tiles[1][1], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_orange.png")).toString())));
        pawnOrange3 = new Pawn(false, tiles[1][2], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_orange.png")).toString())));
        pawnOrange4 = new Pawn(false, tiles[1][3], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_orange.png")).toString())));
        pawnOrange5 = new Pawn(false, tiles[1][4], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_orange.png")).toString())));
        pawnOrange6 = new Pawn(false, tiles[1][5], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_orange.png")).toString())));
        pawnOrange7 = new Pawn(false, tiles[1][6], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_orange.png")).toString())));
        pawnOrange8 = new Pawn(false, tiles[1][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_orange.png")).toString())));

        //Setup for Blue-Team
        rookBlue1 = new Rook(true, tiles[7][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/rook_blue.png")).toString())));
        knightBlue1 = new Knight(true, tiles[7][1], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/knight_blue.png")).toString())));
        bishopBlue1 = new Bishop(true, tiles[7][2], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/bishop_blue.png")).toString())));
        kingBlue = new King(true, tiles[7][3], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/king_blue.png")).toString())));
        queenBlue = new Queen(true, tiles[7][4], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/queen_blue.png")).toString())));
        bishopBlue2 = new Bishop(true, tiles[7][5], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/bishop_blue.png")).toString())));
        knightBlue2 = new Knight(true, tiles[7][6], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/knight_blue.png")).toString())));
        rookBlue2 = new Rook(true, tiles[7][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/rook_blue.png")).toString())));
        pawnBlue1 = new Pawn(true, tiles[6][0], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_blue.png")).toString())));
        pawnBlue2 = new Pawn(true, tiles[6][1], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_blue.png")).toString())));
        pawnBlue3 = new Pawn(true, tiles[6][2], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_blue.png")).toString())));
        pawnBlue4 = new Pawn(true, tiles[6][3], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_blue.png")).toString())));
        pawnBlue5 = new Pawn(true, tiles[6][4], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_blue.png")).toString())));
        pawnBlue6 = new Pawn(true, tiles[6][5], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_blue.png")).toString())));
        pawnBlue7 = new Pawn(true, tiles[6][6], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_blue.png")).toString())));
        pawnBlue8 = new Pawn(true, tiles[6][7], new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/images/figures/orange/pawn_blue.png")).toString())));
    }
}