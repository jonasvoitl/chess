package net.htlgkr.groupK.chess.controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import net.htlgkr.groupK.chess.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingScreenClientController implements Initializable {

    @FXML
    public Text text_ph_socketAddress;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text_ph_socketAddress.setText(Main.dataFromClient.getIpAddress());
    }
}

