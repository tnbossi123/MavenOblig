package org.example;

import java.util.ArrayList;


public class CustomerRegistery {


    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    public void CustomerRegistery(String inName, String inAdress, String inCountry, String inCity, String inZip, int inDay, int inMonth, int inYear, String inEmail, String inPassword, String inNumber) throws InvalidDateException {

        if (inDay < 1 || inDay > 31) {

            // throws exception if the date is wrong
            throw new InvalidDateException("You have chosen a unvalid date (1-31)");

        } else if(inMonth < 1 || inMonth > 12){

            // throws exception if the month is wrong
            throw new InvalidDateException("You have chosen a unvalid month(1-12)");

        } else if (inYear < 1900 || inYear > 2020){

            // throws exception if the year is wrong
            throw new InvalidDateException("You have chosen a unvalid year (1900-2020)");

        } else {

            // Create a new Customer
                Customer newCustomer = new Customer(inName, inAdress, inCountry, inCity, inZip, inDay, inMonth, inYear, inEmail, inPassword, inNumber);

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
