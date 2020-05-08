package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CustomerReader {

    public static List<Customer> readCustomer(Path path) throws IOException{
        ArrayList<Customer> customerList = new ArrayList<>();

        try (var reader = Files.newBufferedReader(path)){
            String line;

            while ((line = reader.readLine()) != null) {
                Customer customer = ParseCustomer.parseCustomer(line);
                customerList.add(customer);
            }
        }

        return customerList;
    }

}
