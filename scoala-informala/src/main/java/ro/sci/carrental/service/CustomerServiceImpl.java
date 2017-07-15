package ro.sci.carrental.service;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CustomerService.
 */
public class CustomerServiceImpl<T extends Customer, V> implements CustomerService<Customer, String> {

    private CustomerRepository<Customer, String> customerRepository;

    public CustomerServiceImpl(CustomerRepository<Customer, String> customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(Customer customer) {
        this.customerRepository.add(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.customerRepository.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        this.customerRepository.update(customer);
    }

    @Override
    public List<Customer> findCustomerByLastName(String lastName) {

        List<Customer> foundCustomers = new ArrayList<>();

        for (Customer customer : customerRepository.getAll()) {
            if (customer.getLastName().equalsIgnoreCase(lastName)) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }

    @Override
    public List<Customer> findCustomerByFullName(String firstName, String lastName) {
        List<Customer> foundCustomers = new ArrayList<>();

        for (Customer customer : customerRepository.getAll()) {
            if ((customer.getFirstName().equalsIgnoreCase(firstName))
                    && (customer.getLastName().equalsIgnoreCase(lastName))) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }

    @Override
    public List<Customer> findCustomerByTelephone(String telephone) {
        List<Customer> foundCustomers = new ArrayList<>();

        for (Customer customer : customerRepository.getAll()) {
            if ((customer.getTelephone().equalsIgnoreCase(telephone))) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }
}
