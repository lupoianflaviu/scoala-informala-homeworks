package ro.sci.carrental.service;

import ro.sci.carrental.domain.Customer;
import ro.sci.carrental.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CustomerService.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findCustomerByLastName(String lastName) {

        List<Customer> foundCustomers = new ArrayList<Customer>();

        for (Customer customer : customerRepository.getAll()) {
            if (customer.getLastName().equalsIgnoreCase(lastName)) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }

    public List<Customer> findCustomerByFullName(String firstName, String lastName) {
        List<Customer> foundCustomers = new ArrayList<Customer>();

        for (Customer customer : customerRepository.getAll()) {
            if ((customer.getFirstName().equalsIgnoreCase(firstName))
                    && (customer.getLastName().equalsIgnoreCase(lastName))) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }

    public List<Customer> findCustomerByTelephone(String telephone) {
        List<Customer> foundCustomers = new ArrayList<Customer>();

        for (Customer customer : customerRepository.getAll()) {
            if ((customer.getTelephone().equalsIgnoreCase(telephone))) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }
}
