package org.example;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/*
public class FileSaverJobj implements FileSaver {

    @Override
    public void save(ItemRegistery registery, Path filePath) throws IOException{

        Path path = Paths.get("items.jobj");
        try (OutputStream os = Files.newOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(os)){
            out.writeObject(registery);
        }

    }


}
 */

