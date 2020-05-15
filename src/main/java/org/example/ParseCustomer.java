package org.example;

import java.time.LocalDate;

public class ParseCustomer {


    public static Customer parseCustomer(String str) throws InvalidCustomerFormatException {

        // Splits a string in parts with a DEKINITTER(seperator);

        String[] strings = str.split(CustomerFormatter.DELIMITTER);

        if (strings.length != 10) {
            throw new InvalidCustomerFormatException("Wrong use or special character");
        }

        String name = strings[0];
        String adress = strings[1];
        String country = strings[2];
        String city = strings[3];
        String zip = strings[4];
        int day;
        int month;
        int year;

        // Testing the numbers if they are numbers
        try {
            day = Integer.parseInt(strings[5]);
            month = Integer.parseInt(strings[6]);
            year = Integer.parseInt(strings[7]);
        } catch(NumberFormatException e){
            // If not numbers throw exception
            throw new NumberFormatException("You have not written a valid date/month/year");

        }
        String email = strings[8];
        String password = strings[9];
        String phoneNumber = strings[10];

        // If all goes well returing customer
        return new Customer(name, adress, country, city, zip, day, month, year, email, password, phoneNumber);
    }

}
