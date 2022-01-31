package net.htlgkr.groupK.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CNT_loadingScreenServer implements Initializable {

    @FXML
    public Text text_ph_password;

    public Text getText_ph_password() {
        return text_ph_password;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.text_ph_password.setText(Server.password);
    }
}

