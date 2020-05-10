package org.example;

import java.util.List;

public class CustomerFormatter {


    public static String DELIMITTER = ";";

    public static String formatCustomer(Customer c){
        return c.getName() + DELIMITTER + c.getAdress() + DELIMITTER + c.getCountry() + DELIMITTER + c.getCity() + DELIMITTER + c.getZip() + DELIMITTER + c.getBirthday() + DELIMITTER + c.getEmail() + DELIMITTER + c.getPhoneNumber() + DELIMITTER + c.getPassword();
    }

    public static String formatCustomers(List<Customer> clist){

        StringBuffer str = new StringBuffer();

        for (Customer c : clist){
            str.append(formatCustomer(c));
            str.append("\n");
        }

        return str.toString();

    }


}
