package ro.sci.carrental.simulations;

import ro.sci.carrental.repository.CustomerRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simulates customer searches with different criteria.
 */
public class SimulateCustomer {
    public void searches(CustomerRepository customerRepository) {
        final Logger LOGGER = Logger.getLogger("RentingSimulation");
        LOGGER.log(Level.INFO, "Lista clientilor din sistem este: {0}\n", customerRepository.getAll());
    }
}
