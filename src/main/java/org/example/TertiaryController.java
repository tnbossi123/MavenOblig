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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;
import java.util.stream.Stream;

public class TertiaryController {

    CustomerRegistery newCustomer = new CustomerRegistery();

    @FXML
    private TextField inName;

    @FXML
    private TextField inAdress;

    @FXML
    private TextField inCountry;

    @FXML
    private TextField inCity;

    @FXML
    private TextField inZip;

    @FXML
    private TextField inDay;
    @FXML
    private TextField inMonth;
    @FXML
    private TextField inYear;

    @FXML
    private TextField inEmail;

    @FXML
    private TextField inPassword;

    @FXML
    private TextField inNumber;

    // Register Form
    @FXML
    void btnRegister(ActionEvent event) {

        // Getting values
        String name = inName.getText();
        String adress = inAdress.getText();
        String country = inCountry.getText();
        String city = inCity.getText();
        String zip = inZip.getText();
        String day = inDay.getText();
        String month = inMonth.getText();
        String year = inYear.getText();
        String email = inEmail.getText();
        String password = inPassword.getText();
        String phoneNumber = inNumber.getText();


        //Validating name, email, password, phonenumber
        try {

            //Name, IllegalarguemntException
            CustomerValidator.nameValidator(name);

            //Adress
            CustomerValidator.adressValidator(adress);

            //Country
            CustomerValidator.countryValidator(country);

            //City
            CustomerValidator.cityValidator(city);

            //Zip
            CustomerValidator.zipValidator(zip);

            //email
            CustomerValidator.emailValidator(email);

            //password
            CustomerValidator.passwordValidator(password);

            //phonenumber
            CustomerValidator.numberValidator(phoneNumber);

            // Path where customers get registered
            Path path = Paths.get("customers.txt");

            try (Stream<String> stream = Files.lines(path)) {

                //searcg all
                Optional<String> lineHavingTarget = stream.filter(l -> l.contains(email)).findFirst();
                // do whatever

               if (!lineHavingTarget.isPresent()){

                   System.out.println("The email is valid for use");

                   // creates the new customer
                   newCustomer.CustomerRegistery(name, adress, country, city, zip, day, month, year, email, password, phoneNumber);

                   // Wrtie to file //////////////////////////
                   //Fromater
                   String formatert = CustomerFormatter.formatCustomers(newCustomer.getCustomerReg());
                   try {
                       CustomerWriter.writeString(path, formatert);
                       System.out.println("Customer is registered");
                       App.setRoot("secondary");
                   } catch (IOException e){
                       System.err.println("Something went wrong: " + e.getMessage());
                   }

                }else {
                   System.out.println("The email you have chosen has already been registered, use another Email");

                }


            } catch(IOException e){
            System.out.println("The email you have entered already exists, choose another Email");
            }



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
