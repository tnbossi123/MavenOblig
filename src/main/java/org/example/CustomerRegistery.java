package org.example;

import java.util.ArrayList;

public class CustomerRegistery {


    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    public void CustomerRegistery(String inName, String inAdress, String inCity, String inZip, String inBirthday, String inEmail, String inPassword, String inNumber, int lblCustomerId) {

// Create a new Customer
        Customer newCustomer = new Customer(inName, inAdress, inCity, inZip, inBirthday, inEmail, inPassword, inNumber, lblCustomerId);

        // Put in a array
        customerArrayList.add(newCustomer);

    }


    //Array gets made to a String
    public String customerList() {
        String out = "";

        for (Customer newCustomer : customerArrayList) {
            out += newCustomer;
        }

        return out;
    }


}
