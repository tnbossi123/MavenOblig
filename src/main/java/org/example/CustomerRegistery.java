package org.example;

import java.util.ArrayList;

public class CustomerRegistery {


    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    public void CustomerRegistery(String lblName, String lblAdress, String lblCity, String lblZip, String lblBirthday, String lblEmail, String lblPhoneNumber, int lblCustomerId) {

// Create a new Customer
        Customer newCustomer = new Customer(lblName, lblAdress, lblCity, lblZip, lblBirthday, lblEmail, lblPhoneNumber, lblCustomerId);

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
