package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomerWriter {

    public static void writeString(Path path, String str) throws IOException{
        Files.write(path, str.getBytes());
    }

}
