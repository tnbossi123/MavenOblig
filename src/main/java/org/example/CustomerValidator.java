package org.example;

public class CustomerValidator {


    // Name
    public static void nameValidator(String nameV){


        if (!nameV.matches("[A-ZÆØÅ][a-zæøå]{0,20}[ ]?[A-ZÆØÅ]?[a-zæøå]{0,20}")){

            throw new IllegalArgumentException("Unvalid name");

        }
    }

    //Country
    public static void countryValidator(String countryV){


        if (!countryV.matches("^[^\\s]+[a-zA-Z]{2,}+$")){

            throw new IllegalArgumentException("Unvalid country");

        }
    }


    // Adress
    public static void adressValidator(String adressV){


        if (!adressV.matches("^(.+) (\\d{1,3}[A-Z]?[a-z]?)")){

            throw new IllegalArgumentException("Unvalid address");

        }
    }

    // City
    public static void cityValidator(String cityV){


        if (!cityV.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")){

            throw new IllegalArgumentException("Unvalid city");

        }
    }

    // Zip
    public static void zipValidator(String zipV){


        if (!zipV.matches("^\\d{4}$")){

            throw new IllegalArgumentException("Unvalid zip");

        }
    }

    // Email
    public static void emailValidator(String emailV){

        if (!emailV.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){

            throw new IllegalArgumentException("Unvalid Email");

        }

    }

    //Password
    public static void passwordValidator(String passwordV){

        if (!passwordV.matches(
                "(?-i)(?=^.{7,}$)((?!.*\\s)(?=.*[A-Z])(?=.*[a-z]))((?=(.*\\d){1,})|(?=(.*\\W){1,}))^.*$")){

            throw new IllegalArgumentException("Unvalid Password, must have at least 8 characters, at least 1 uppercase and 1 lowercase letter, at least 1 digit or 1 alphanumeric, no spaces");

        }

    }

    // Telephone numnber
    public static void numberValidator(String numberV){

        if (!numberV.matches("[+|(+]*[0-9]{0,3}[)]?[ ]?[- 0-9]{8,13}")){

            throw new IllegalArgumentException("Unvalid number");

        }

    }



    }





