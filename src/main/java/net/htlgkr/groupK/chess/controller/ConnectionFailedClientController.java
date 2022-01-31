package net.htlgkr.groupK.chess.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.htlgkr.groupK.chess.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConnectionFailedClientController implements Initializable {

    @FXML
    public Button btn_enterDataAgain;

    public Button getBtn_enterDataAgain() {
        return btn_enterDataAgain;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btn_enterDataAgain.setOnAction(actionEvent -> {
            System.out.println("open new loginPrompt");
            Main.createLoginPrompt(Main.stage);
        });
    }
}
