package ro.sci.carrental.service;

import java.util.List;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepository;

/**
 * Service interface for customer.
 *
 * @author flaviu.lupoian
 */
public interface CustomerService<T> {

    /**
     * Add Customer in Customer Repository
     */
    void add(T customer);

    /**
     * Delete Customer in Customer Repository * @param customer
     */
    void delete(T customer);

    /**
     * Update Customer in Customer Repository * @param customer
     */
    void update(T customer);

    /**
     * Get all customers in Customer Repository
     *
     * @return List<T> list of Customers
     */
    List<T> getAll();

    /**
     * Find customers by last name.
     *
     * @param lastName Customer Last Name
     */
    List<T> findCustomerByLastName(String lastName);

    /**
     * Find customers by full name.
     *
     * @param firstName Customer First Name
     * @param lastName  Customer Last Name
     */
    List<T> findCustomerByFullName(String firstName, String lastName);

    /**
     * Find customers by telephone.
     *
     * @param telephone Customer telephone number
     */
    List<T> findCustomerByTelephone(String telephone);

    /**
     * Setter for Rpository injection
     *
     * @param customerRepository Repository
     */
    void setCustomerRepository(CustomerRepository<Customer> customerRepository);
}
