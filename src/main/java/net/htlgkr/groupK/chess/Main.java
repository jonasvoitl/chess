package net.htlgkr.groupK.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        createMenuScreen(stage);
    }

    public static void main(String[] args) {
        launch();
    }

    public static void createMenuScreen(Stage stageMenuScreen) throws IOException
    {
        FXMLLoader menuScreen = new FXMLLoader(Main.class.getResource("menu-screen.fxml"));
        Scene sceneMenuScreen = new Scene(menuScreen.load(), 600, 400);
        stageMenuScreen.setScene(sceneMenuScreen);
        stageMenuScreen.show();
    }

    public static void createChessGame(Stage stageChessGame) throws IOException
    {
        FXMLLoader chessGame = new FXMLLoader(Main.class.getResource("chess-game.fxml"));
        Scene sceneChessGame = new Scene(chessGame.load(), 500, 700);
        stageChessGame.setScene(sceneChessGame);

        stageChessGame.setResizable(false);
        Image icon = new Image(Main.class.getResource("/images/chess_icon.jpg").toString());
        stageChessGame.getIcons().add(icon);
        stageChessGame.setTitle("Chess Game");

        stageChessGame.show();
    }
}