package ro.sci.carrental.simulations;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepositoryImpl;
import ro.sci.carrental.service.CustomerServiceImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simulates customer searches with different criteria.
 */
public class SimulateCustomer {
    public void searches(CustomerRepositoryImpl customerRepository) {
        final Logger LOGGER = Logger.getLogger("RentingSimulation");
        LOGGER.log(Level.INFO, "Lista clientilor din sistem este: {0}\n", customerRepository.getAll());
    }
}
