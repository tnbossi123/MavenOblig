package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileSaverTxt  implements FileSaver{

    public static void save(Path path, String str) throws IOException{
        Files.write(path, str.getBytes());
    }

    @Override
    public void save(Path path, ArrayList<Item> inputArray) throws IOException {

    }
}
