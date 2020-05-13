package org.example;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class PrimaryController {

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button primaryButton;

    @FXML
    void btnLogin(ActionEvent event) throws IOException {


            String userName = loginUsername.getText();
            String userPassword = loginPassword.getText();


            Path customerPath = Paths.get("customers.txt");
            Path adminPath = Paths.get("admin.txt");

            // Customer login
        // jeg tror denne setningen her må forandres på
            try (Stream<String> CustomerStream = Files.lines(customerPath)){
                // Search all

                //Måten å gjøre dette på er med supplier
              // Supplier<Stream<String>> userNameSupplier = () -> CustomerStream.filter(l -> l.contains(userName));
               //Supplier<Stream<String>> passwordSupplier = () -> CustomerStream.filter(l -> l.contains(userPassword));


               Optional<String> userNameTarget = CustomerStream.filter(l -> l.contains(userName)).findFirst();
               Optional<String> userPasswordTarget = CustomerStream.filter(l -> l.contains(userPassword)).findFirst();

                // Checking if these targets match to login as customer

                if (userNameTarget.isPresent() && userPasswordTarget.isPresent()){

                    System.out.println(userName + ", have succsessfully loged in");

                    App.setRoot("secondary");

                }else{
                    System.out.println("The email/password choosen does either not exist or is typed wrong");
                }

            } catch (IOException e){
                System.err.println("Error: " + e.getMessage());
            }




/*
            // Admin login
            try (Stream<String> AdminStream = Files.lines(adminPath)){
                // Search all
                Optional<String> userNameTarget = AdminStream.filter(l -> l.contains(userName)).findFirst();
                Optional<String> userPasswordTarget = AdminStream.filter(l -> l.contains(userPassword)).findFirst();

                // Checking if these targets match to login as customer

                if (userNameTarget.isPresent() && userPasswordTarget.isPresent()){

                    System.out.println(userName + ", Welcome Admin");

                    App.setRoot("quaternary");

                }else{
                    System.out.println("The email/password choosen does either not exist or is typed wrong");
                }

            } catch (IOException e){
                System.err.println("Error: " + e.getMessage());
            }catch (RuntimeException e){
                System.err.println("problem på admin");
            }

 */





    }

    @FXML
    void switchToTertiary(ActionEvent event) throws IOException {
        App.setRoot("tertiary");
    }

}






