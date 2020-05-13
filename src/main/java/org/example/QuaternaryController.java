package org.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class QuaternaryController {

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
    App.setRoot("primary");
    }

}
