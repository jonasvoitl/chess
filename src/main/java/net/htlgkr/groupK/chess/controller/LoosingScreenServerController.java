package net.htlgkr.groupK.chess.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import net.htlgkr.groupK.chess.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class LoosingScreenServerController implements Initializable {

    @FXML
    public Text text_ph_loosingText;

    public Text getText_ph_loosingText() {
        return text_ph_loosingText;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text_ph_loosingText.setText(Main.dataFromClient.getUserName() + " hat das Spiel gewonnen.");
    }
}
