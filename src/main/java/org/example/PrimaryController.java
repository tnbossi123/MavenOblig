package org.example;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static org.example.App.setRoot;


public class PrimaryController {

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button primaryButton;

    //label popup
    @FXML
    private Label label;



    @FXML
    void btnLogin(ActionEvent event) throws IOException {

        // Logins (username and password)
        String userName = loginUsername.getText();
        String userPassword = loginPassword.getText();

        // the different file paths
        Path customerPath = Paths.get("customers.txt");
        Path adminPath = Paths.get("admin.txt");

        // Different scanners that will scan in their own path
        final Scanner customerScanner = new Scanner(customerPath);
        final Scanner adminScanner = new Scanner(adminPath);

        try{

            // Chekcs if the username is a valid email adress
            CustomerValidator.emailValidator(userName);

            // chekcs the customer file first to seee if the user excists there
            while (customerScanner.hasNextLine()){
                final String customerLineFromFile = customerScanner.nextLine();
                if (customerLineFromFile.contains(userName) && customerLineFromFile.contains(userPassword)){
                    System.out.println("Customer: Congrats mothafucka " + userName + " u have logged in");
                    // Sends customer to the customer page
                    App.setRoot("secondary");
                    break;
                } else{
                    System.out.println("Customer: Either ur Username or password is wrong");
                    label.setText("Incorrect Email or password.");
                }
            }

            // Checks then the admin file too see if the user exists there
            while (adminScanner.hasNextLine()){
                final String adminLineFromFile = adminScanner.nextLine();
                if (adminLineFromFile.contains(userName) && adminLineFromFile.contains(userPassword)){
                    System.out.println("Admin: Congrats mothafucking " + userName + " u have logged in");
                    // Sends admin to the admin page
                    App.setRoot("quaternary");
                    break;
                } else {
                    System.out.println("Admin: Either ur Username or password is wrong");
                    label.setText("Invalid Email or password");
                }

            }

        }
        // If the username failed, you will get this message
        catch (IllegalArgumentException e) {
            System.err.println("Valid username is only your email");
        }


    }

    @FXML
    void switchToTertiary(ActionEvent event) throws IOException {
        setRoot("tertiary");
    }

}






