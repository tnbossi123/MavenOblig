package org.example;

import javafx.scene.control.Alert;

public class Dialogs {

    public static void showErrorDialog(String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Unvalid data!");
        alert.setContentText(msg);

        alert.showAndWait();
    }

    public static void showSuccesDialog(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Item registery");
        alert.setHeaderText("Successful Operation");
        alert.setContentText(msg);

        alert.showAndWait();
    }

}
