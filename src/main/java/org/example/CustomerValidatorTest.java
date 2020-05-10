package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerValidatorTest {

    // Valid Names
    @Test
    public void nameValidator() {
        org.example.CustomerValidator.nameValidator("Per");
        org.example.CustomerValidator.nameValidator("Billy Bazyy");
        org.example.CustomerValidator.nameValidator("Ørn Ærlingså");
    }

    // Invalid Names
    @Test
    public void testInvalidNavn(){

        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.nameValidator(""));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.nameValidator(" "));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.nameValidator("123"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.nameValidator("Blerton123"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.nameValidator("123Blerton"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.nameValidator("123Blerton123"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.nameValidator("!Blerton"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.nameValidator("@Blerton"));

    }

    // Valid Country
    @Test
    public void countryValidator() {
        org.example.CustomerValidator.countryValidator("Norway");
        org.example.CustomerValidator.countryValidator("Lüneburg");
        org.example.CustomerValidator.countryValidator("Czechoslovakia");
    }

    // Invalid Adress
    @Test
    public void testInvalidCountry(){

        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.countryValidator(""));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.countryValidator(" "));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.countryValidator(" Norway"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.countryValidator("Norway "));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.countryValidator("norway1"));

    }


    // Valid Adress
    @Test
    public void adressValidator() {
        org.example.CustomerValidator.adressValidator("Linderudsletta 19");
        org.example.CustomerValidator.adressValidator("Frognerveien 28A");
        org.example.CustomerValidator.adressValidator("Veitvet 1a");
    }

    // Invalid Adress
    @Test
    public void testInvalidAdress(){

        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.adressValidator(""));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.adressValidator(" "));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.adressValidator(";Linderudsletta@"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.adressValidator("Linderudsletta@"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.adressValidator(";Linderudsletta;19A"));

    }

    // Valid Adress
    @Test
    public void cityValidator() {
        org.example.CustomerValidator.cityValidator("Bacau");
        org.example.CustomerValidator.cityValidator("Balneario Camboriu");
        org.example.CustomerValidator.cityValidator("Bandar-e Anzali");
        org.example.CustomerValidator.cityValidator("Skopje");
    }

    // Invalid Adress
    @Test
    public void testInvalidCity(){

        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.cityValidator(""));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.cityValidator(" "));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.cityValidator(" Chicago"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.cityValidator("Chigao-"));

    }


    // Valid Zip
    @Test
    public void zipValidator() {
        org.example.CustomerValidator.zipValidator("0001");
        org.example.CustomerValidator.zipValidator("0597");
        org.example.CustomerValidator.zipValidator("9035");
    }




    // Invalid Zip
    @Test
    public void testInvalidZip(){

        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.zipValidator(""));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.zipValidator(" "));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.zipValidator("    "));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.zipValidator("abcd"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.zipValidator("12345"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.zipValidator("123"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.zipValidator("ab12;"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.zipValidator("ab;jgfssa"));

    }

    // Valid Email

    @Test
    void emailValidator() {

        org.example.CustomerValidator.emailValidator("blerton.selami@oslomet.no");
        org.example.CustomerValidator.emailValidator("example@example.com");
        org.example.CustomerValidator.emailValidator("uk@domain.co.uk");
    }

    // Invalid Email

    @Test
    public void testInvalidEmail(){

        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.emailValidator(""));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.emailValidator("blerton.selami"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.emailValidator("@oslomet.no"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.emailValidator("blerton.selami@invalid"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.emailValidator("test@"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.emailValidator(";bot@evil.com"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.emailValidator(" "));

    }



    // Valid Password
    // http://regexlib.com/REDetails.aspx?regexp_id=2062

    @Test
    void passwordValidator() {

        org.example.CustomerValidator.passwordValidator("a3dAbed5");
        org.example.CustomerValidator.passwordValidator("P@ssword1");
        org.example.CustomerValidator.passwordValidator("myPassw0rd!");
        org.example.CustomerValidator.passwordValidator("aB_1bbbb");

    }

    // Invalid Password

    @Test
    public void testInvalidPassword(){

        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.passwordValidator("password"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.passwordValidator("password12"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.passwordValidator("password__12"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.passwordValidator("p@ssword"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.passwordValidator("12345678"));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.passwordValidator("Mypass1 "));
        assertThrows(IllegalArgumentException.class, () -> org.example.CustomerValidator.passwordValidator(" Password1_ "));

    }


    //Valid PhoneNumbers

    @Test
    void numberValidator() {


        org.example.CustomerValidator.numberValidator("12233212");
        org.example.CustomerValidator.numberValidator("+4712233212");
        org.example.CustomerValidator.numberValidator("+47 12233212");
        org.example.CustomerValidator.numberValidator("(+47)12233212");
        org.example.CustomerValidator.numberValidator("(+47) 12233212");
        org.example.CustomerValidator.numberValidator("(+47) 12 23 32 12");
        org.example.CustomerValidator.numberValidator("07911 123456");
        org.example.CustomerValidator.numberValidator("+44 7911 123456");
        org.example.CustomerValidator.numberValidator("754-3010");
        org.example.CustomerValidator.numberValidator("(541) 754-3010");
        org.example.CustomerValidator.numberValidator("+1-541-754-3010");
        org.example.CustomerValidator.numberValidator("1-541-754-3010");
        org.example.CustomerValidator.numberValidator("001-541-754-3010");

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