package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
/*
public class FileOpenerJobj implements FileOpener{

    @Override
    public void open(ItemRegistery registery, Path filePath) throws IOException{
        try(InputStream fin = Files.newInputStream(filePath);
            ObjectInputStream oin = new ObjectInputStream(fin)){
                ItemRegistery registery1 = (ItemRegistery) oin.readObject();
                registery.removeAll();
                registery1.getItemRegister().forEach(registery::addItem);
        } catch (ClassNotFoundException e){
            e.printStackTrace(); // Debugging information
            throw new IOException("Something is wrong with the implementation. See debug information");
        }
    }

}


 */