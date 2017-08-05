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
 * CustomerWriter implements interface EntityWriter to write Customers to file
 *
 * @param <Customer> Customer to write
 */
public class CustomerWriter<Customer> implements EntityWriter<Customer> {
    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    @Override
    public void writeObjects(List<Customer> customerRepository, File file) {
        Charset charset = Charset.forName("UTF8");

        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset)) {

            ListIterator iterator = customerRepository.listIterator();

            while (iterator.hasNext()) {
                writer.write(iterator.next().toString());

                if (!iterator.hasNext()) {
                    break;
                }
                writer.write("\n");
            }

            LOGGER.log(Level.INFO, "\nCustomers Writing DONE.");

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "IO exception found!" + e);
        }
    }
}
