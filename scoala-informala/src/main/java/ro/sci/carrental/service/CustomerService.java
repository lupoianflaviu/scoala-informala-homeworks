package ro.sci.carrental.service;

import java.util.List;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepository;

/**
 * Service interface for customer.
 */
public interface CustomerService<T> {

    /**
     * Add Customer in Customer Repository
     */
    void add(T customer);

    /**
     * Delete Customer in Customer Repository
     */
    void delete(T customer);

    /**
     * Update Customer in Customer Repository
     */
    void update(T customer);

    /**
     * Get all customers in Customer Repository
     */
    List<T> getAll();

    /**
     * Find customers by last name.
     */
    List<T> findCustomerByLastName(String lastName);

    /**
     * Find customers by full name.
     */
    List<T> findCustomerByFullName(String firstName, String lastName);

    /**
     * Find customers by telephone.
     */
    List<T> findCustomerByTelephone(String telephone);

    void setCustomerRepository(CustomerRepository<Customer> customerRepository);
}
