package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface FileOpener {

    static ArrayList<Item> read(Path path) throws IOException, ClassNotFoundException {
        return null;
    }

}
