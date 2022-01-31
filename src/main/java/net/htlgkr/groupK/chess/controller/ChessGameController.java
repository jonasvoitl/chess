package net.htlgkr.groupK.chess.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.sockets.Client;
import net.htlgkr.groupK.chess.sockets.Server;

import java.net.URL;
import java.util.ResourceBundle;

public class ChessGameController implements Initializable {
    @FXML
    public Label text_userName_blue;

    @FXML
    public Label text_userName_orange;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            this.text_userName_blue.setText(Main.data.getServer().getUserName());
            this.text_userName_orange.setText(Main.data.getClient().getUserName());
        });
    }
}