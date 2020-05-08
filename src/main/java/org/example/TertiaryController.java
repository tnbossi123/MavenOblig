package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;

public class TertiaryController {

    CustomerRegistery newCustomer = new CustomerRegistery();

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

    private Window PrimaryStage;


    // Register Form
    @FXML
    void btnRegister(ActionEvent event) {

        // Getting values
        String name = inName.getText();
        String adress = inAdress.getText();
        String city = inCity.getText();
        String zip = inZip.getText();
        LocalDate birthday = inBirthday.getValue();
        String email = inEmail.getText();
        String password = inPassword.getText();
        String phoneNumber = inNumber.getText();


        //Validating name, email, password, phonenumber
        try {

            //Name, IllegalarguemntException
            CustomerValidator.nameValidator(name);

            //email
            CustomerValidator.emailValidator(email);

            //password
            CustomerValidator.passwordValidator(password);

            //phonenumber
            CustomerValidator.numberValidator(phoneNumber);

            newCustomer.CustomerRegistery(name, adress, city, zip, birthday, email, password, phoneNumber);

            // Wrtie to file //////////////////////////
            // Path
            Path path = Paths.get("customers.txt");
            //Fromater
            String formatert = CustomerFormatter.formatCustomers(newCustomer.getCustomerReg());
            try {
                CustomerWriter.writeString(path, formatert);
                System.out.println("Customer is registered");
            } catch (IOException e){
                System.err.println("Something went wrong: " + e.getMessage());
            }
            ///////////////


        } catch (IllegalArgumentException e){
            System.err.println("Error: " + e.getMessage());
        } catch (RuntimeException e){
            System.err.println("Error: " + e.getMessage());
        }


    }

    // Goes back to primary if user regrets forwarding to register, or clicked wrong
    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {

        App.setRoot("primary");

    }

}
