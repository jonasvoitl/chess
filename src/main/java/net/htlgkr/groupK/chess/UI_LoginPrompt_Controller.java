package net.htlgkr.groupK.chess;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;

public class UI_LoginPrompt_Controller {

    @FXML
    private TextField idIPAddress;

    @FXML
    private Button idJoinGameButton;

    @FXML
    private TextField idPortNumber;

    @FXML
    private TextField idUserName;

    @FXML
    private PasswordField idUserPassword;

    public TextField getIdIPAddress() {
        return idIPAddress;
    }

    public Button getIdJoinGameButton() {
        return idJoinGameButton;
    }

    public TextField getIdPortNumber() {
        return idPortNumber;
    }

    public TextField getIdUserName() {
        return idUserName;
    }

    public PasswordField getIdUserPassword() {
        return idUserPassword;
    }
}

