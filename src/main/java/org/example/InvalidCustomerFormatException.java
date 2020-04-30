package org.example;

import java.io.IOException;

public class InvalidCustomerFormatException extends IOException {

    InvalidCustomerFormatException(String message){
        super(message);
    }


}
