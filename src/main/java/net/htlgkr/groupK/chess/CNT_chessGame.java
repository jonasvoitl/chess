package net.htlgkr.groupK.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CNT_chessGame implements Initializable {
    @FXML
    public Label text_userName_blue;

    @FXML
    public Label text_userName_orange;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.text_userName_blue.setText(Server.userName);
        this.text_userName_orange.setText(Client.userName);
    }
}