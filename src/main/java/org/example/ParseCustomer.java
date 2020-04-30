package org.example;

public class ParseCustomer {


    public static Customer ParseCustomer(String str) throws InvalidCustomerFormatException {

        // Splits a string in parts with a DEKINITTER(seperator);

        String[] strings = str.split(CustomerFormatter.DELIMITTER);

        if (strings.length != 7) {
            throw new InvalidCustomerFormatException("Wrong use og speciall character");
        }

        String name = strings[0];
        String adress = strings[1];
        String city = strings[2];
        String zip = strings[3];
        String birthday = strings[4];
        String email = strings[5];
        String phoneNumber = strings[6];
        int customerId;

        try {
            customerId = Integer.parseInt(strings[7]);
        } catch (NumberFormatException e) {
            throw new InvalidCustomerFormatException("Invalid id");
        }


        return new Customer(name, adress, city, zip, birthday, email, phoneNumber, customerId);
    }

}
