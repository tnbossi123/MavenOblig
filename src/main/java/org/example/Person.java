package org.example;

import java.time.LocalDate;

public class Person {
        // Attributes
        String name;
        String adress;
        String city;
        String zip;
        LocalDate birthday;
        String email;
        String password;
        String phoneNumber;

        // Constructors
        public Person(String name, String adress, String city, String zip, LocalDate birthday, String email, String password, String phoneNumber){
            this.name = name;
            this.adress = adress;
            this.city = city;
            this.zip = zip;
            this.birthday = birthday;
            this.email = email;
            this.password = password;
            this.phoneNumber = phoneNumber;
        }

        // Getters
        public String getName() {
            return name;
        }

        public String getAdress() {
            return adress;
        }

        public String getCity() {
            return city;
        }


        public String getZip() {
            return zip;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getPhoneNumber() {
            return phoneNumber;

        }

    }

    class Customer extends Person{


        public Customer(String name, String adress, String city, String zip, LocalDate birthday, String email, String password, String phoneNumber) {
            super(name, adress, city, zip, birthday, email, password, phoneNumber);

        }

    }


    class Admin extends Person{

        int adminId;

        public Admin(String name, String adress, String city, String zip, LocalDate birthday, String email, String password, String phoneNumber, int adminId) {
            super(name, adress, city, zip, birthday, email, password, phoneNumber);
            this.adminId = adminId;
        }

        public int getAdminId() {
            return adminId;
        }
    }

// Needs a toString()


