package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;


public class CustomerRegistery {


    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    public void CustomerRegistery(String inName, String inAdress, String inCountry, String inCity, String inZip, LocalDate inBirthday, String inEmail, String inPassword, String inNumber) throws RuntimeException {

        if (inBirthday == null) {

            throw new RuntimeException("You have not chosen a birthday");

        } else {

            // Create a new Customer
                Customer newCustomer = new Customer(inName, inAdress, inCountry, inCity, inZip, inBirthday, inEmail, inPassword, inNumber);

                // Put in a array
                customerArrayList.add(newCustomer);

        }
    }



    //Array gets made to a String
    public String customerList() {
        String out = "";

        for (Customer newCustomer : customerArrayList) {
            out += newCustomer;
        }

        return out;
    }


    // Get Customer reistery
    public ArrayList<Customer> getCustomerReg(){
        ArrayList<Customer> outPutArray = new ArrayList<>(customerArrayList);
        return outPutArray;
    }


}
