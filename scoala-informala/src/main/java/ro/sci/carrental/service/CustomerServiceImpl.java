package ro.sci.carrental.service;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CustomerService.
 */
public class CustomerServiceImpl implements CustomerService<Customer> {

    private CustomerRepository<Customer> customerRepository;

    public CustomerServiceImpl(CustomerRepository<Customer> customerRepository) {
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
    public void update(Customer customer, Customer newCustomer) {
        this.customerRepository.update(customer, newCustomer);
    }

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.getAll();
    }

    @Override
    public List<Customer> findCustomerByLastName(String lastName) {

        return customerRepository.getCustomerByLastName(lastName);
    }

    @Override
    public List<Customer> findCustomerByFullName(String firstName, String lastName) {
        return customerRepository.getCustomerByFullName(firstName, lastName);
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
