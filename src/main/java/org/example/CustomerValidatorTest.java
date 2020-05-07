package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerValidatorTest {

    @Test
    public void nameValidator(String nameV) {
        nameValidator("Per");
        nameValidator("Billy Bazyy");
        nameValidator("Ørn Ærlingså");
    }

    // Invalid Names
    @Test
    public void testInvalidNavn(){

        assertThrows(IllegalArgumentException.class, () -> nameValidator(""));
        assertThrows(IllegalArgumentException.class, () -> nameValidator(" "));
        assertThrows(IllegalArgumentException.class, () -> nameValidator("123"));
        assertThrows(IllegalArgumentException.class, () -> nameValidator("Blerton123"));
        assertThrows(IllegalArgumentException.class, () -> nameValidator("123Blerton"));
        assertThrows(IllegalArgumentException.class, () -> nameValidator("123Blerton123"));
        assertThrows(IllegalArgumentException.class, () -> nameValidator("!Blerton"));
        assertThrows(IllegalArgumentException.class, () -> nameValidator("@Blerton"));

    }


    // Valid Email

    @Test
    void emailValidator(String emailV) {

        emailValidator("blerton.selami@oslomet.no");
        emailValidator("example@example.com");
        emailValidator("uk@domain.co.uk");
    }

    // Invalid Email

    @Test
    public void testInvalidEmail(){

        assertThrows(IllegalArgumentException.class, () -> emailValidator(""));
        assertThrows(IllegalArgumentException.class, () -> emailValidator("blerton.selami"));
        assertThrows(IllegalArgumentException.class, () -> emailValidator("@oslomet.no"));
        assertThrows(IllegalArgumentException.class, () -> emailValidator("blerton.selami@invalid"));
        assertThrows(IllegalArgumentException.class, () -> emailValidator("test@"));
        assertThrows(IllegalArgumentException.class, () -> emailValidator(";bot@evil.com"));
        assertThrows(IllegalArgumentException.class, () -> emailValidator(" "));

    }



    // Valid Password

    @Test
    void passwordValidator(String passwordV) {

        passwordValidator("");
        passwordValidator("");
        passwordValidator("");
    }

    // Invalid Password

    @Test
    public void testInvalidPassword(){

        assertThrows(IllegalArgumentException.class, () -> passwordValidator(""));
        assertThrows(IllegalArgumentException.class, () -> passwordValidator(""));
        assertThrows(IllegalArgumentException.class, () -> passwordValidator(""));
        assertThrows(IllegalArgumentException.class, () -> passwordValidator(""));
        assertThrows(IllegalArgumentException.class, () -> passwordValidator(""));
        assertThrows(IllegalArgumentException.class, () -> passwordValidator(""));
        assertThrows(IllegalArgumentException.class, () -> passwordValidator(""));

    }


    //Valid PhoneNumbers

    @Test
    void numberValidator(String numberV) {


        numberValidator("12233212");
        numberValidator("+4712233212");
        numberValidator("+47 12233212");
        numberValidator("(+47)12233212");
        numberValidator("(+47) 12233212");
        numberValidator("(+47) 12 23 32 12");
        numberValidator("07911 123456");
        numberValidator("+44 7911 123456");
        numberValidator("754-3010");
        numberValidator("(541) 754-3010");
        numberValidator("+1-541-754-3010");
        numberValidator("1-541-754-3010");
        numberValidator("001-541-754-3010");

    }

    // Invalid Telephone Number

    @Test
    public void testInvalidNumber(){

        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.numberValidator(""));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.numberValidator(" "));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.numberValidator("abc"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.numberValidator("-231"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.numberValidator("123-norway"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.numberValidator("1-541-æøå-3010"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.numberValidator("1-541-abc-3010"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.numberValidator("!%&/"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.numberValidator("123 123     123 12"));

    }
}