package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;

public class FileOpenerTxt implements FileOpener {

        public static ArrayList<Item> read(Path path) throws IOException {


            ArrayList<Item> list = new ArrayList<>();
            try (BufferedReader reader = Files.newBufferedReader(path)) {

                String line;

                // create a new item for wach line
                while ((line = reader.readLine()) != null){
                    Item t = ParseItem.parseItem(line);
                    list.add(t);
                }
            }
                return list;
        }


}
