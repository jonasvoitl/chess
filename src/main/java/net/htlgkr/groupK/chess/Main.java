package net.htlgkr.groupK.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.htlgkr.groupK.chess.controller.ChessGameController;
import net.htlgkr.groupK.chess.gamelogic.MoveHandler;
import net.htlgkr.groupK.chess.sockets.Client;
import net.htlgkr.groupK.chess.sockets.Server;

import java.io.IOException;

public class Main extends Application {
    public static Stage stage;
    public static Data dataFromServer;
    public static Data dataFromClient;
    public static ChessGameController chessGameController;
    public static MoveHandler moveHandler;
    public static boolean isServer;

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
        try {
            Scene sceneLoginPrompt = new Scene(loginPrompt.load(), 600, 400);
            stage.setScene(sceneLoginPrompt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Login");
        stage.show();
    }

    public static void createChessGame(Stage stage) {
        FXMLLoader chessGame = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/chess-game.fxml"));
        try {
            Scene sceneChessGame = new Scene(chessGame.load());
            stage.setScene(sceneChessGame);
        } catch (IOException e) {
            e.printStackTrace();
        }
        chessGameController = chessGame.getController();
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Schach");
        stage.show();
    }

    public static void createLoadingScreenServer(Stage stage) {
        FXMLLoader loadingScreenServer = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/loading-screen-server.fxml"));
        try {
            Scene sceneLoadingScreenServer = new Scene(loadingScreenServer.load(), 600, 400);
            stage.setScene(sceneLoadingScreenServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Warten auf Gegner");
        stage.show();
    }

    public static void createLoadingScreenClient(Stage stage) {
        FXMLLoader loadingScreenClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/loading-screen-client.fxml"));
        try {
            Scene sceneLoadingScreenClient = new Scene(loadingScreenClient.load(), 600, 400);
            stage.setScene(sceneLoadingScreenClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Warten auf Gegner");
        stage.show();
    }

    public static void createPasswordIncorrectScreenClient(Stage stage) {
        FXMLLoader passwordIncorrectScreenClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/password-incorrect-screen-client.fxml"));
        try {
            Scene scenePasswordIncorrectScreenClient = new Scene(passwordIncorrectScreenClient.load(), 600, 400);
            stage.setScene(scenePasswordIncorrectScreenClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Passwort falsch");
        stage.show();
    }

    public static void createConnectionFailedClient(Stage stage) {
        FXMLLoader connectionFailedClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/connection-failed-client.fxml"));
        try {
            Scene sceneConnectionFailedClient = new Scene(connectionFailedClient.load(), 600, 400);
            stage.setScene(sceneConnectionFailedClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Passwort falsch");
        stage.show();
    }

    public static void createWinningScreenClient(Stage stage) {
        FXMLLoader winningScreenClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/winning-screen-client.fxml"));
        try {
            Scene sceneWinningScreenClient = new Scene(winningScreenClient.load(), 600, 400);
            stage.setScene(sceneWinningScreenClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Gewonnen!");
        stage.show();
    }

    public static void createWinningScreenServer(Stage stage) {
        FXMLLoader winningScreenServer = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/winning-screen-server.fxml"));
        try {
            Scene sceneWinningScreenServer = new Scene(winningScreenServer.load(), 600, 400);
            stage.setScene(sceneWinningScreenServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Gewonnen!");
        stage.show();
    }

    public static void createLoosingScreenClient(Stage stage) {
        FXMLLoader loosingScreenClient = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/loosing-screen-client.fxml"));
        try {
            Scene sceneLoosingScreenClient = new Scene(loosingScreenClient.load(), 600, 400);
            stage.setScene(sceneLoosingScreenClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Verloren!");
        stage.show();
    }

    public static void createLoosingScreenServer(Stage stage) {
        FXMLLoader loosingScreenServer = new FXMLLoader(Main.class.getResource("/net/htlgkr/groupK/chess/loosing-screen-server.fxml"));
        try {
            Scene sceneLoosingScreenServer = new Scene(loosingScreenServer.load(), 600, 400);
            stage.setScene(sceneLoosingScreenServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toString()));
        stage.setTitle("Verloren!");
        stage.show();
    }
    //TODO IDs umbenennen (keine _)
    //TODO darf nicht eigene Figuren schlagen
    //TODO Figuren schlagen
    //TODO abwechselnd Züge auswählen
}