package org.example;

import java.time.LocalDate;

public class ParseCustomer {


    public static Customer parseCustomer(String str) throws InvalidCustomerFormatException {

        // Splits a string in parts with a DEKINITTER(seperator);

        String[] strings = str.split(CustomerFormatter.DELIMITTER);

        if (strings.length != 7) {
            throw new InvalidCustomerFormatException("Wrong use or special character");
        }

        String name = strings[0];
        String adress = strings[1];
        String country = strings[2];
        String city = strings[3];
        String zip = strings[4];
        LocalDate birthday = LocalDate.parse(strings[5]);
        String email = strings[6];
        String password = strings[7];
        String phoneNumber = strings[8];

        return new Customer(name, adress, country, city, zip, birthday, email, password, phoneNumber);
    }

}
