package net.htlgkr.groupK.chess.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.sockets.Server;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingScreenServerController implements Initializable {

    @FXML
    public Text text_ph_password;

    public Text getText_ph_password() {
        return text_ph_password;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.text_ph_password.setText(Main.data.getServer().getPassword());
    }
}

