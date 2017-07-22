package ro.sci.carrental.simulations;

import ro.sci.carrental.repository.CustomerRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simulates customer searches with different criteria.
 */
public class SimulateCustomer {
    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    public void searches(CustomerRepository customerRepository) {

        LOGGER.log(Level.INFO, "\nLista clientilor din sistem este: {0}\n", customerRepository.getAll());
    }
}
