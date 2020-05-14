package org.example;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;


public class SecondaryController implements Initializable {


    @FXML
    private RadioButton rbGas;

    @FXML
    private RadioButton rbElectrical;

    @FXML
    private RadioButton rbHybrid;

    @FXML
    private ComboBox<String> cbBrand;
    private final String[] brand = {"BMW", "Mercedes-Benz", "Audi"};
    private final ObservableList<String> brandList = FXCollections.observableArrayList(brand);

    @FXML
    private ComboBox<String> cbColor;
    private final String[] color = {"Red", "White", "Black"};
    private final ObservableList<String> colorList = FXCollections.observableArrayList(color);



    @FXML
    private RadioButton rb14;

    @FXML
    private RadioButton rb16;

    @FXML
    private RadioButton rb19;

    @FXML
    private ToggleGroup tireSize;

    @FXML
    private Button secondaryButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initialize the lists
        cbColor.setItems(colorList);
        cbBrand.setItems(brandList);

    }

    @FXML
    private Button btnOrder;

    @FXML
    private TextArea taSummary;

    @FXML
    private ImageView image1;

    @FXML
    void orderAction(ActionEvent event) {
        Order order = new Order();
        DecimalFormat currency = new DecimalFormat("$,###.00");



        if (rb14.isSelected()){
            order.setPrice2(200);

        } else if (rb16.isSelected() ){
            order.setPrice2(400);

        }  else if (rb19.isSelected()){
            order.setPrice2(700);

        }


        if (rbGas.isSelected()){
            order.setType(1); // 1 for gas, 2 for electrical, 3 for hybrid
            order.setColor(cbColor.getSelectionModel().getSelectedIndex());
            order.setPrice(1000);
            taSummary.appendText(rbGas.getText() + " "
                    + cbBrand.getValue() + " in " + cbColor.getValue() + " with " +
                    ((RadioButton) tireSize.getSelectedToggle()).getText() + " wheels " +
                    currency.format(order.getPrice() + order.getPrice2())
                    + " "  + "\n");

        } else if (rbElectrical.isSelected() ){
            order.setType(2);
            order.setColor(cbColor.getSelectionModel().getSelectedIndex());
            order.setPrice(2000);
            taSummary.appendText(rbElectrical.getText() + " "
                    + cbBrand.getValue() + " in " + cbColor.getValue() + " with " +
                    ((RadioButton) tireSize.getSelectedToggle()).getText() + " wheels " +
                    currency.format(order.getPrice() + order.getPrice2())
                    + " "  + "\n");

        } else if (rbHybrid.isSelected()){
            order.setType(3);
            order.setColor(cbColor.getSelectionModel().getSelectedIndex());
            order.setPrice(3000);
            taSummary.appendText(rbHybrid.getText() + " "
                    + cbBrand.getValue() + " in " + cbColor.getValue() + " with " +
                    ((RadioButton) tireSize.getSelectedToggle()).getText() + " wheels " +
                    currency.format(order.getPrice() + order.getPrice2())
                    + " "  + "\n");
        } else {
            taSummary.appendText("Choose the parts of your car build!\n");
        }


    }



    @FXML
    void resetAction(ActionEvent event) {
        rbGas.setSelected(false);
        rbElectrical.setSelected(false);
        rbHybrid.setSelected(false);
        cbColor.setValue(null);
        cbBrand.setValue(null);
        rb14.setSelected(false);
        rb16.setSelected(false);
        rb19.setSelected(false);
        taSummary.setText(null);
    }




    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }



}

