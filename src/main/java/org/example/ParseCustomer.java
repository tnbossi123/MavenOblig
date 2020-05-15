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
        String day = strings[5];
        String month = strings[6];
        String year = strings[7];
        String email = strings[8];
        String password = strings[9];
        String phoneNumber = strings[10];

        return new Customer(name, adress, country, city, zip, day, month, year, email, password, phoneNumber);
    }

}
