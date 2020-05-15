package org.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class QuaternaryController implements Initializable {

        ItemRegistery newItem = new ItemRegistery();

        @FXML
        private TableView<Item> tableView;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
                newItem.attachTableView(tableView);
        }

        @FXML
        private TextField productName;

        @FXML
        private TextField productPrice;

        @FXML
        private RadioButton rbPrice;

        @FXML
        private TextField lblSearch;

        @FXML
        private TableColumn<TableView<Item>, String> productColumn;

        @FXML
        private TableColumn<TableView<Item>, Integer> priceColumn;

        private Window PrimaryStage;



        // Register list
        @FXML
        void registerBtnClicked(ActionEvent event) {

                String product = productName.getText();
                int price = Integer.parseInt(productPrice.getText());

                try{
                        // Validating product name
                        ItemValidator.itemNameValidator(product);

                        // Validating product price
                        ItemValidator.itemPriceValidator(price);

                        newItem.ItemRegistery(product,price);
                } catch (IllegalArgumentException e){
                        System.out.println("ERROR: " + e.getMessage());
                }
        }

        // Saves to file
        @FXML
        void saveFileMenuClicked(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();

                // Set extension filter for text files
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt", "*.jobj");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showSaveDialog(PrimaryStage);

                Path path = Paths.get(file.getPath());
                String formated = ItemFormatter.formatItems(newItem.getItemRegister());
                try {
                        FileSaverTxt.save(path, formated);
                        System.out.println("Saved" + file);
                } catch (IOException e){
                        System.out.println("Error" + e.getMessage());
                }
        }

        // Opens file
        @FXML
        void openFileMenuClicked(ActionEvent event) {

                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt", "*.jobj");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showOpenDialog(PrimaryStage);

                Path path = Paths.get(file.getPath());

                try {
                        ArrayList<Item> items = FileOpenerTxt.read(file.toPath());
                        newItem.setItemRegister(items);
                        System.out.println("Opened " + file);
                } catch (IOException e) {
                        System.out.println("Error" + e.getMessage());
                        e.getStackTrace();
                }
        }

        @FXML
        void filter(KeyEvent event){
                RadioButton selected = (RadioButton) rbPrice.getToggleGroup().getSelectedToggle();
                newItem.filterItemRegister(selected.getText(), lblSearch.getText(), tableView);
        }


    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
    App.setRoot("primary");
    }

        public void productChange(TableColumn.CellEditEvent<Item, String> event) {

                try{
                        event.getRowValue().setItemName(event.getNewValue());
                } catch (IllegalArgumentException e){
                        Dialogs.showErrorDialog("Unvalid product name: " + e.getMessage());
                }
                tableView.refresh();
        }

        public void priceChange(TableColumn.CellEditEvent<Item, Integer> event) {

                try {
                        event.getRowValue().setItemPrice(event.getNewValue());
                } catch (NumberFormatException e){
                        Dialogs.showErrorDialog("Unvalid price: " + e.getMessage());
                }

                tableView.refresh();
        }
}
