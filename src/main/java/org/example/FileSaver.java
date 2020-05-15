package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface FileSaver {

    void save(Path path, ArrayList<Item> inputArray) throws IOException;

}
