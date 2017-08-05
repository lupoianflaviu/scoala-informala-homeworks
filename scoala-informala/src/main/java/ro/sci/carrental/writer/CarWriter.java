package ro.sci.carrental.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CarWriter implements EntityWriter
 * @param <Car> Car to write to file
 */
public class CarWriter<Car> implements EntityWriter<Car> {
    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    @Override
    public void writeObjects(List<Car> carRepository, File file) {
        Charset charset = Charset.forName("UTF8");

        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset)) {

            ListIterator iterator = carRepository.listIterator();

            while (iterator.hasNext()) {
                writer.write(iterator.next().toString());

                if (!iterator.hasNext()) {
                    break;
                }
                writer.write("\n");
            }

            LOGGER.log(Level.INFO, "\nCars Writing DONE.");

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "IO exception found!" + e);
        }
    }
}
