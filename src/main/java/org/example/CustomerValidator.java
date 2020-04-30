package org.example;

public class CustomerValidator {


    // Name
    public static void nameValidator(String nameV){


        if (!nameV.matches("[A-ZÆØÅ][a-zæøå]{0,20}[ ]?[A-ZÆØÅ]?[a-zæøå]{0,20}")){

            throw new IllegalArgumentException("Unvalid name");

        }
    }

    // Email
    public static void emailValidator(String emailV){

        if (!emailV.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){

            throw new IllegalArgumentException("Unvalid Email");

        }

    }

    // Telephone numnber
    public static void numberValidator(String numberV){

        if (!numberV.matches("[+|(+]*[0-9]{0,3}[)]?[ ]?[- 0-9]{8,13}")){

            throw new IllegalArgumentException("Unvalid number");

        }

    }


}
