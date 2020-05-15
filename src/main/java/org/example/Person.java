package org.example;

import java.time.LocalDate;

public class Person {
        // Attributes
        String name;
        String adress;
        String country;
        String city;
        String zip;
        int day;
        int month;
        int year;
        String email;
        String password;
        String phoneNumber;

        // Constructors
        public Person(String name, String adress, String country, String city, String zip, int day, int month, int year, String email, String password, String phoneNumber){
            this.name = name;
            this.adress = adress;
            this.country = country;
            this.city = city;
            this.zip = zip;
            this.day = day;
            this.month = month;
            this.year = year;
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

        public String getCountry() {
        return country;
    }

        public String getZip() {
            return zip;
        }

        public int getDay() {
        return day;
    }
        public int getMonth() {
        return month;
    }
        public int getYear() {
        return year;
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


        public Customer(String name, String adress, String country, String city, String zip ,int day, int  month, int year , String email, String password, String phoneNumber) {
            super(name, adress, country, city, zip, day, month, year, email, password, phoneNumber);

        }

    }

