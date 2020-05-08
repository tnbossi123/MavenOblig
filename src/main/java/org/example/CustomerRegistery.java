package org.example;

import java.time.LocalDate;
import java.util.ArrayList;



public class CustomerRegistery {


    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    public void CustomerRegistery(String inName, String inAdress, String inCity, String inZip, LocalDate inBirthday, String inEmail, String inPassword, String inNumber) throws RuntimeException {

        if (inBirthday != null) {

                // Create a new Customer
                Customer newCustomer = new Customer(inName, inAdress, inCity, inZip, inBirthday, inEmail, inPassword, inNumber);

                // Put in a array
                customerArrayList.add(newCustomer);

        } else {

            throw new RuntimeException("You have not choosen a birthday");

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
