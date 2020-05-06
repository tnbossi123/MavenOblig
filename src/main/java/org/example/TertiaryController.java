package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TertiaryController {

    @FXML
    private TextField inCity;

    @FXML
    private TextField inZip;

    @FXML
    private TextField inEmail;

    @FXML
    private TextField inNumber;

    @FXML
    private TextField inAdress;

    @FXML
    private TextField inName;

    @FXML
    private DatePicker inBirthday;

    @FXML
    private TextField inPassword;


    @FXML
    void btnRegister(ActionEvent event) {

    }

    // Goes back to primary if user regrets forwarding to register, or clicked wrong
    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {

        App.setRoot("primary");

    }

}
