package ro.sci.carrental.service;

import ro.sci.carrental.domain.customer.Customer;

import java.util.List;

/**
 * Service interface for customer.
 */
public interface CustomerService {

    /**
     * Add Customer in Customer Repository
     */
    void add(Customer customer);

    /**
     * Delete Customer in Customer Repository
     */
    void delete(Customer customer);

    /**
     * Update Customer in Customer Repository
     */
    void update(Customer customer);

    /**
     * Find customers by last name.
     * @param lastName
     * @return
     */
    List<Customer> findCustomerByLastName(String lastName);

    /**
     * Find customers by full name.
     * @param firstName
     * @param lastName
     * @return
     */
    List<Customer> findCustomerByFullName(String firstName, String lastName);

    /**
     * Find customers by telephone.
     * @param telephone
     * @return
     */
    List<Customer> findCustomerByTelephone(String telephone);
}
