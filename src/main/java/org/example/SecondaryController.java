package org.example;

import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
    private ComboBox<String> brandSelector;

    @FXML
    private ComboBox<String> cbColor;
    private final String[] color = {"red", "white"};
    private final ObservableList<String> colorList = FXCollections.observableArrayList(color);

    @FXML
    public void initialize() throws IOException{


        // Reading items from txt file

        BufferedReader brandRead = new BufferedReader(new FileReader("brands.txt"));

        try {
            StringBuilder sb = new StringBuilder();
            String line = brandRead.readLine();

            while (line != null){

                brandSelector.getItems().addAll(line);

                sb.append(line);
                line = brandRead.readLine();
            }
        } finally {
            brandRead.close();
            System.out.println(brandSelector);

        }

        brandSelector.getSelectionModel().select(0);

    }




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



    }



    @FXML
    private Button btnOrder;

    @FXML
    private TextArea taSummary;

    @FXML
    private ImageView image1;


    @FXML
    void orderAction(ActionEvent event) throws FileNotFoundException {
        Order order = new Order();
        DecimalFormat currency = new DecimalFormat("$,###.00");

        //Saving previous user's order(s)
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);


        //Setting each price on the buttons
        if (rb14.isSelected()){
            order.setPrice2(200);

        } else if (rb16.isSelected() ){
            order.setPrice2(400);

        }  else if (rb19.isSelected()){
            order.setPrice2(700);

        }

        //Setting each price on the buttons
        if (rbGas.isSelected()){
            order.setType(1); // 1 for gas, 2 for electrical, 3 for hybrid
            order.setColor(cbColor.getSelectionModel().getSelectedIndex());
            order.setPrice(1000);

            //PrintStream, writes info on the last order of the last buyer to output.txt
            System.out.println(rbGas.getText() + " "
                     + " in " + cbColor.getValue() + " with " +
                    ((RadioButton) tireSize.getSelectedToggle()).getText() + " wheels " +
                    currency.format(order.getPrice() + order.getPrice2())
                    + " "  + "\n");

            taSummary.appendText(rbGas.getText() + " "
                     + " in " + cbColor.getValue() + " with " +
                    ((RadioButton) tireSize.getSelectedToggle()).getText() + " wheels " +
                    currency.format(order.getPrice() + order.getPrice2())
                    + " "  + "\n");


        } else if (rbElectrical.isSelected() ){
            order.setType(2);
            order.setColor(cbColor.getSelectionModel().getSelectedIndex());
            order.setPrice(2000);

            //output.txt
            System.out.println(rbElectrical.getText() + " in " + cbColor.getValue() + " with " +
                    ((RadioButton) tireSize.getSelectedToggle()).getText() + " wheels " +
                    currency.format(order.getPrice() + order.getPrice2())
                    + " "  + "\n");
            taSummary.appendText(rbElectrical.getText() + " "
                     + " in " + cbColor.getValue() + " with " +
                    ((RadioButton) tireSize.getSelectedToggle()).getText() + " wheels " +
                    currency.format(order.getPrice() + order.getPrice2())
                    + " "  + "\n");

        } else if (rbHybrid.isSelected()){
            order.setType(3);
            order.setColor(cbColor.getSelectionModel().getSelectedIndex());
            order.setPrice(3000);

            //output.txt
            System.out.println(rbHybrid.getText() + " "
                     + " in " + cbColor.getValue() + " with " +
                    ((RadioButton) tireSize.getSelectedToggle()).getText() + " wheels " +
                    currency.format(order.getPrice() + order.getPrice2())
                    + " "  + "\n");

            taSummary.appendText(rbHybrid.getText() + " "
                     + " in " + cbColor.getValue() + " with " +
                    ((RadioButton) tireSize.getSelectedToggle()).getText() + " wheels " +
                    currency.format(order.getPrice() + order.getPrice2())
                    + " "  + "\n");
        } else {
            taSummary.appendText("Choose the parts of your car build!\n");
        }


    }




//Reset button for all values
    @FXML
    void resetAction(ActionEvent event) {
        rbGas.setSelected(false);
        rbElectrical.setSelected(false);
        rbHybrid.setSelected(false);
        cbColor.setValue(null);

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

