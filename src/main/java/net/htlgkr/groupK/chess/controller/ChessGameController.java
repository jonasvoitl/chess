package net.htlgkr.groupK.chess.controller;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.figures.*;
import net.htlgkr.groupK.chess.gamelogic.Index;
import net.htlgkr.groupK.chess.Main;
import java.net.URL;
import java.util.*;

public class ChessGameController implements Initializable
{
    private Map<Index, Figure> tilesMap = new HashMap<>();
    private List<Figure> orangeFigures = new ArrayList<>();
    private List<Figure> blueFigures = new ArrayList<>();
    private Label[][] tiles;

    private Index selectedFigureIndex;
    private Index nextPositionIndex;

    private EventHandler<MouseEvent> onMouseClickEvent;

    @FXML
    public GridPane GP_backgroundChessBoard;

    @FXML
    public Label text_userName_blue;

    @FXML
    public Label text_userName_orange;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        createOnMouseClickedEvent();
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
                tile.addEventFilter(MouseEvent.MOUSE_CLICKED, onMouseClickEvent);

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
                GP_backgroundChessBoard.add(tile, j, i);
            }
        }
    }

    private void setStartingPositions()
    {
        //Setup for Orange-Team
        Rook orangeRook1 = new Rook(false, "/images/figures/orange/rook_orange.png");
        tiles[0][0].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(orangeRook1.getImagePath())).toString(), 75, 75, false, false)));
        tiles[0][0].setAlignment(Pos.CENTER);
        orangeFigures.add(orangeRook1);
        tilesMap.put(new Index(0, 0), orangeRook1);

        Knight orangeKnight1 = new Knight(false, "/images/figures/orange/knight_orange.png");
        tiles[0][1].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(orangeKnight1.getImagePath())).toString(), 75, 75, false, false)));
        tiles[0][1].setAlignment(Pos.CENTER);
        orangeFigures.add(orangeKnight1);
        tilesMap.put(new Index(0, 1), orangeKnight1);

        Bishop orangeBishop1 = new Bishop(false, "/images/figures/orange/bishop_orange.png");
        tiles[0][2].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(orangeBishop1.getImagePath())).toString(), 75, 75, false, false)));
        tiles[0][2].setAlignment(Pos.CENTER);
        orangeFigures.add(orangeBishop1);
        tilesMap.put(new Index(0, 2), orangeBishop1);

        King orangeKing = new King(false, "/images/figures/orange/king_orange.png");
        tiles[0][3].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(orangeKing.getImagePath())).toString(), 75, 75, false, false)));
        tiles[0][3].setAlignment(Pos.CENTER);
        orangeFigures.add(orangeKing);
        tilesMap.put(new Index(0, 3), orangeKing);

        Queen orangeQueen = new Queen(false, "/images/figures/orange/queen_orange.png");
        tiles[0][4].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(orangeQueen.getImagePath())).toString(), 75, 75, false, false)));
        tiles[0][4].setAlignment(Pos.CENTER);
        orangeFigures.add(orangeQueen);
        tilesMap.put(new Index(0, 4), orangeQueen);

        Bishop orangeBishop2 = new Bishop(false, "/images/figures/orange/bishop_orange.png");
        tiles[0][5].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(orangeBishop2.getImagePath())).toString(), 75, 75, false, false)));
        tiles[0][5].setAlignment(Pos.CENTER);
        orangeFigures.add(orangeBishop2);
        tilesMap.put(new Index(0, 5), orangeBishop2);

        Knight orangeKnight2 = new Knight(false, "/images/figures/orange/knight_orange.png");
        tiles[0][6].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(orangeKnight2.getImagePath())).toString(), 75, 75, false, false)));
        tiles[0][6].setAlignment(Pos.CENTER);
        orangeFigures.add(orangeKnight2);
        tilesMap.put(new Index(0, 6), orangeKnight2);

        Rook orangeRook2 = new Rook(false, "/images/figures/orange/rook_orange.png");
        tiles[0][7].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(orangeRook2.getImagePath())).toString(), 75, 75, false, false)));
        tiles[0][7].setAlignment(Pos.CENTER);
        orangeFigures.add(orangeRook2);
        tilesMap.put(new Index(0, 7), orangeRook2);

        for (int i = 0; i < tiles[1].length; i++)
        {
            Pawn orangePawn = new Pawn(false, "/images/figures/orange/pawn_orange.png");
            tiles[1][i].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(orangePawn.getImagePath())).toString(), 75, 75, false, false)));
            tiles[1][i].setAlignment(Pos.CENTER);
            orangeFigures.add(orangePawn);
            tilesMap.put(new Index(1, i), orangePawn);
        }


        //Setup for Blue-Team
        Rook blueRook1 = new Rook(true, "/images/figures/blue/rook_blue.png");
        tiles[7][0].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(blueRook1.getImagePath())).toString(), 75, 75, false, false)));
        tiles[7][0].setAlignment(Pos.CENTER);
        blueFigures.add(blueRook1);
        tilesMap.put(new Index(7, 0), blueRook1);

        Knight blueKnight1 = new Knight(true, "/images/figures/blue/knight_blue.png");
        tiles[7][1].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(blueKnight1.getImagePath())).toString(), 75, 75, false, false)));
        tiles[7][1].setAlignment(Pos.CENTER);
        blueFigures.add(blueKnight1);
        tilesMap.put(new Index(7, 1), blueKnight1);

        Bishop blueBishop1 = new Bishop(true, "/images/figures/blue/bishop_blue.png");
        tiles[7][2].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(blueBishop1.getImagePath())).toString(), 75, 75, false, false)));
        tiles[7][2].setAlignment(Pos.CENTER);
        blueFigures.add(blueBishop1);
        tilesMap.put(new Index(7, 2), blueBishop1);

        King blueKing = new King(true, "/images/figures/blue/king_blue.png");
        tiles[7][3].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(blueKing.getImagePath())).toString(), 75, 75, false, false)));
        tiles[7][3].setAlignment(Pos.CENTER);
        blueFigures.add(blueKing);
        tilesMap.put(new Index(7, 3), blueKing);

        Queen blueQueen = new Queen(true, "/images/figures/blue/queen_blue.png");
        tiles[7][4].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(blueQueen.getImagePath())).toString(), 75, 75, false, false)));
        tiles[7][4].setAlignment(Pos.CENTER);
        blueFigures.add(blueQueen);
        tilesMap.put(new Index(7, 4), blueQueen);

        Bishop blueBishop2 = new Bishop(true, "/images/figures/blue/bishop_blue.png");
        tiles[7][5].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(blueBishop2.getImagePath())).toString(), 75, 75, false, false)));
        tiles[7][5].setAlignment(Pos.CENTER);
        blueFigures.add(blueBishop2);
        tilesMap.put(new Index(7, 5), blueBishop2);

        Knight blueKnight2 = new Knight(true, "/images/figures/blue/knight_blue.png");
        tiles[7][6].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(blueKnight2.getImagePath())).toString(), 75, 75, false, false)));
        tiles[7][6].setAlignment(Pos.CENTER);
        blueFigures.add(blueKnight2);
        tilesMap.put(new Index(7, 6), blueKnight2);

        Rook blueRook2 = new Rook(true, "/images/figures/blue/rook_blue.png");
        tiles[7][7].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(blueRook2.getImagePath())).toString(), 75, 75, false, false)));
        tiles[7][7].setAlignment(Pos.CENTER);
        blueFigures.add(blueRook2);
        tilesMap.put(new Index(7, 7), blueRook2);

        for (int i = 0; i < tiles[6].length; i++)
        {
            Pawn bluePawn = new Pawn(true, "/images/figures/blue/pawn_blue.png");
            tiles[6][i].setGraphic(new ImageView(new Image(Objects.requireNonNull(Main.class.getResource(bluePawn.getImagePath())).toString(), 75, 75, false, false)));
            tiles[6][i].setAlignment(Pos.CENTER);
            blueFigures.add(bluePawn);
            tilesMap.put(new Index(6, i), bluePawn);
        }

        //Alle übrigen Tiles adden
        for (int i = 2; i < tiles.length-2; i++)
        {
            for (int j = i; j < tiles[i].length; j++)
            {
                tilesMap.put(new Index(i, j), null);
            }
        }
    }

    public void createOnMouseClickedEvent()
    {
        onMouseClickEvent = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                if(selectedFigureIndex == null)
                {
                    Index index = new Index(GridPane.getRowIndex((Node) mouseEvent.getTarget()), GridPane.getColumnIndex((Node) mouseEvent.getTarget()));

                    if(tilesMap.get(index) == null)
                    {
                        selectedFigureIndex = index;
                    }

                    System.out.println(tilesMap.get(index));
                    System.out.println(index);
                }
                else
                {
                    Figure selectedFigure = tilesMap.get(selectedFigureIndex);

                    Index index = new Index(GridPane.getRowIndex((Node) mouseEvent.getTarget()), GridPane.getColumnIndex((Node) mouseEvent.getTarget()));

                    if(tilesMap.get(index) != null)
                    {
                        nextPositionIndex = index;

                        Figure figureNextPosition = tilesMap.get(nextPositionIndex);
                        ImageView selectedImageView = new ImageView(new Image(selectedFigure.getImagePath()));

                        selectedFigure.setImagePath(null);
                    }

                    selectedFigureIndex = null;
                }
            }
        };
    }
}