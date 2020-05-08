package org.example;

import java.time.LocalDate;

public class ParseCustomer {


    public static Customer parseCustomer(String str) throws InvalidCustomerFormatException {

        // Splits a string in parts with a DEKINITTER(seperator);

        String[] strings = str.split(CustomerFormatter.DELIMITTER);

        if (strings.length != 7) {
            throw new InvalidCustomerFormatException("Wrong use og speciall character");
        }

        String name = strings[0];
        String adress = strings[1];
        String city = strings[2];
        String zip = strings[3];
        LocalDate birthday = LocalDate.parse(strings[4]);
        String email = strings[5];
        String password = strings[6];
        String phoneNumber = strings[7];

        return new Customer(name, adress, city, zip, birthday, email, password, phoneNumber);
    }

}
