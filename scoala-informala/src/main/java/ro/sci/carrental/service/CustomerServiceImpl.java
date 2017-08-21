package ro.sci.carrental.service;

import java.util.ArrayList;
import java.util.List;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepository;

/**
 * Implementation of CustomerService.
 */
public class CustomerServiceImpl implements CustomerService<Customer> {

    private CustomerRepository<Customer> customerRepository;

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
            if ((customer.getTelephone()
                         .equalsIgnoreCase(telephone))) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }

    @Override
    public void setCustomerRepository(CustomerRepository<Customer> customerRepository) {
        this.customerRepository = customerRepository;
    }

}
