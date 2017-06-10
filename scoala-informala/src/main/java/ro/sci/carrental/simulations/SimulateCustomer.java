package ro.sci.carrental.simulations;

import ro.sci.carrental.domain.Customer;
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
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
        }
        System.out.println("_____________________________________");

        //cautare dupa numele de familie
        CustomerServiceImpl search1 = new CustomerServiceImpl(customerRepository);
        List<Customer> foundCustomersByLastName = search1.findCustomerByLastName("Cretu");

        System.out.println("Cautarea dupa numele de familie returneaza urmatorii clienti: ");
        for (Customer customer : foundCustomersByLastName) {
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
        }
        System.out.println("######################################");

    }
}
