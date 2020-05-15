package org.example;

import java.io.IOException;

public class InvalidItemFormatException extends IOException {
    InvalidItemFormatException(String message){
        super(message);
    }
}
