package ro.sci.carrental.simulations;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepositoryImpl;
import ro.sci.carrental.service.CustomerServiceImpl;

import java.util.List;

/**
 * Simulates customer searches with different criteria.
 */
public class SimulateCustomer {
    public void searches(CustomerRepositoryImpl customerRepository) {
        //cautarea tuturor clientilor
        System.out.println("Lista clientilor din sistem este: ");
        for (Customer customer : customerRepository.getAll()) {
            System.out.println(customer.getLastName());
        }
        System.out.println("_____________________________________");
    }
}
