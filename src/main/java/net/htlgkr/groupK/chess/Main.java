package net.htlgkr.groupK.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.htlgkr.groupK.chess.sockets.Client;
import net.htlgkr.groupK.chess.sockets.Server;

import java.io.IOException;

public class Main extends Application {
    public static Stage stage;
    public static Data dataFromServer;
    public static Data dataFromClient;

    public static Server server;
    public static Client client;

    @Override
    public void start(Stage stage) throws IOException
    {
        Main.stage = stage;
        createLoginPrompt(stage);
    }

    public static void main(String[] args) {
        launch();
    }

    public static void createLoginPrompt(Stage stage) {
        FXMLLoader loginPrompt = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/login-prompt.fxml"));
        Scene sceneLoginPrompt = null;
        try {
            sceneLoginPrompt = new Scene(loginPrompt.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Login");
        stage.setScene(sceneLoginPrompt);
        stage.show();
    }

    public static void createChessGame(Stage stage) {
        FXMLLoader chessGame = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/chess-game.fxml"));
        Scene sceneChessGame = null;
        try {
            sceneChessGame = new Scene(chessGame.load(), 500, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Schach");
        stage.setScene(sceneChessGame);
        stage.show();
    }

    public static void createLoadingScreenServer(Stage stage) {
        FXMLLoader loadingScreenServer = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/loading-screen-server.fxml"));
        Scene sceneLoadingScreenServer = null;
        try {
            sceneLoadingScreenServer = new Scene(loadingScreenServer.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Warten auf Gegner");
        stage.setScene(sceneLoadingScreenServer);
        stage.show();
    }

    public static void createLoadingScreenClient(Stage stage) {
        FXMLLoader loadingScreenClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/loading-screen-client.fxml"));
        Scene sceneLoadingScreenClient = null;
        try {
            sceneLoadingScreenClient = new Scene(loadingScreenClient.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Warten auf Gegner");
        stage.setScene(sceneLoadingScreenClient);
        stage.show();
    }

    public static void createPasswordIncorrectScreenClient(Stage stage) {
        FXMLLoader passwordIncorrectScreenClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/password-incorrect-screen-client.fxml"));
        Scene scenePasswordIncorrectScreenClient = null;
        try {
            scenePasswordIncorrectScreenClient = new Scene(passwordIncorrectScreenClient.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Passwort falsch");
        stage.setScene(scenePasswordIncorrectScreenClient);
        stage.show();
    }

    public static void createConnectionFailedClient(Stage stage) {
        FXMLLoader connectionFailedClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/connection-failed-client.fxml"));
        Scene sceneConnectionFailedClient = null;
        try {
            sceneConnectionFailedClient = new Scene(connectionFailedClient.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Passwort falsch");
        stage.setScene(sceneConnectionFailedClient);
        stage.show();
    }
}