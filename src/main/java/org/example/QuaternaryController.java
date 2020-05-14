package org.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class QuaternaryController {

        @FXML
        private TableView<?> tableView;

        @FXML
        private TableColumn<?, ?> birthDayColumn;

        @FXML
        private ChoiceBox<?> filterChoice;

        @FXML
        void birthDayEdited(ActionEvent event) {

        }

        @FXML
        void emailEdited(ActionEvent event) {

        }

        @FXML
        void openFileMenuClicked(ActionEvent event) {

        }

        @FXML
        void registerBtnClicked(ActionEvent event) {

        }

        @FXML
        void saveFileMenuClicked(ActionEvent event) {

        }



        @FXML
        void txtSearch(ActionEvent event) {

        }



    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
    App.setRoot("primary");
    }

}
