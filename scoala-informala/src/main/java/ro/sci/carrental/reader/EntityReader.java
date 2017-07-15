package ro.sci.carrental.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCA on 15/07/2017.
 */
public class EntityReader {

    public List<String> readLines(File file) {
        Charset charset = Charset.forName("UTF8");

        List<String> listInputCars = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                listInputCars.add(line);
            }
        } catch (IOException e) {
            System.err.println("IOException:" + e);
        }
        return listInputCars;
    }
}
