package ro.sci.carrental.service;

import java.util.List;

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
     * Find customers by last name.
     * @param lastName
     * @return
     */
    List<T> findCustomerByLastName(String lastName);

    /**
     * Find customers by full name.
     * @param firstName
     * @param lastName
     * @return
     */
    List<T> findCustomerByFullName(String firstName, String lastName);

    /**
     * Find customers by telephone.
     * @param telephone
     * @return
     */
    List<T> findCustomerByTelephone(String telephone);
}
