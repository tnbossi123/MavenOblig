package org.example;

    public class Person {
        // Attributes
        String name;
        String adress;
        String city;
        String zip;
        String birthday;
        String email;
        String password;
        String phoneNumber;

        // Constructors
        public Person(String name, String adress, String city, String zip, String birthday, String email, String password, String phoneNumber){
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

        public String getBirthday() {
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

        int customerId;

        public Customer(String name, String adress, String city, String zip, String birthday, String email, String password, String phoneNumber, int customerId) {
            super(name, adress, city, zip, birthday, email, password, phoneNumber);
            this.customerId = customerId;
        }

        public int getCustomerId() {
            return customerId;
        }
    }


    class Admin extends Person{

        int adminId;

        public Admin(String name, String adress, String city, String zip, String birthday, String email, String password, String phoneNumber, int adminId) {
            super(name, adress, city, zip, birthday, email, password, phoneNumber);
            this.adminId = adminId;
        }

        public int getAdminId() {
            return adminId;
        }
    }

// Needs a toString()


