package net.htlgkr.groupK.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException
    {
        this.stage = stage;
        createLoginPrompt(stage);
    }

    public static void main(String[] args) {
        launch();
    }

    public static void createLoginPrompt(Stage stage) throws IOException {
        FXMLLoader loginPrompt = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/login-prompt.fxml"));
        Scene sceneLoginPrompt = new Scene(loginPrompt.load(), 600, 400);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Login");
        stage.setScene(sceneLoginPrompt);
        stage.show();
    }

    public static void createChessGame(Stage stage) throws IOException {
        FXMLLoader chessGame = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/chess-game.fxml"));
        Scene sceneChessGame = new Scene(chessGame.load(), 500, 700);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Schach");
        stage.setScene(sceneChessGame);
        stage.show();
    }

    public static void createLoadingScreenServer(Stage stage) throws IOException {
        FXMLLoader loadingScreenServer = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/loading-screen-server.fxml"));
        Scene sceneLoadingScreenServer = new Scene(loadingScreenServer.load(), 600, 400);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Warten auf Gegner");
        stage.setScene(sceneLoadingScreenServer);
        stage.show();
    }

    public static void createLoadingScreenClient(Stage stage) throws IOException {
        FXMLLoader loadingScreenClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/loading-screen-client.fxml"));
        Scene sceneLoadingScreenClient = new Scene(loadingScreenClient.load(), 600, 400);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Warten auf Gegner");
        stage.setScene(sceneLoadingScreenClient);
        stage.show();
    }

    public static void createPasswordIncorrectScreenClient(Stage stage) throws IOException {
        FXMLLoader passwordIncorrectScreenClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/password-incorrect-screen-client.fxml"));
        Scene scenePasswordIncorrectScreenClient = new Scene(passwordIncorrectScreenClient.load(), 600, 400);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Passwort falsch");
        stage.setScene(scenePasswordIncorrectScreenClient);
        stage.show();
    }
}