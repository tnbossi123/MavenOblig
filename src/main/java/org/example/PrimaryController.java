package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class PrimaryController {

    @FXML
    void btnLogin(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private Button primaryButton;

    @FXML
    void switchToSecondary(ActionEvent event) {

    }

}






