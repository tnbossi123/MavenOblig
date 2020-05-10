package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;


public class SecondaryController implements Initializable {

    @FXML
    private ImageView ivGas;

    @FXML
    private ImageView ivColor;

    @FXML
    private ImageView ivWheel;

    @FXML
    private RadioButton rbGas;

    @FXML
    private RadioButton rbElectrical;

    @FXML
    private RadioButton rbHybrid;

    @FXML
    private ChoiceBox<String> cbColor;
    private final String[] color = {"Red", "White", "Black"};
    private final ObservableList<String> colorList = FXCollections.observableArrayList(color);

    @FXML
    private ChoiceBox<String> cbBrand;
    private final String[] brand = {"BMW", "Mercedes-Benz", "Audi"};
    private final ObservableList<String> brandList = FXCollections.observableArrayList(brand);


    @FXML
    private RadioButton rb14;

    @FXML
    private RadioButton rb16;

    @FXML
    private RadioButton rb19;

    @FXML
    private Button secondaryButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initalize the lists
        cbColor.setItems(colorList);
        cbBrand.setItems(brandList);

    }


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }



}

