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

            throw new RuntimeException("You have not choosen a birthday");

        } else {

            try (Stream<String> stream = Files.lines(Paths.get("customers.txt"))) {

                //this one finds the first one
                Optional<String> lineHavingTarget = stream.filter(l -> l.contains(inEmail)).findFirst();


                //this ine finds all and prints them
                //stream.filter(l -> l.contains(inEmail)).forEach(System.out::println);


                // do whatever

            // Create a new Customer
                Customer newCustomer = new Customer(inName, inAdress, inCountry, inCity, inZip, inBirthday, inEmail, inPassword, inNumber);

                // Put in a array
                customerArrayList.add(newCustomer);

            }catch(IOException e){
                System.out.println("The email you have entered allready excist, choose another email");
            }

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
