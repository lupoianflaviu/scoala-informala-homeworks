package ro.sci.carrental.repository;

import java.util.List;

import ro.sci.carrental.domain.customer.Customer;

/**
 * Repository interface for Customer, this will help managing all persistence operations related to Customer.
 */
public interface CustomerRepository<T extends Customer> extends Repository<T> {
    /**
     * Get Customers by LastName.
     *
     * @return List<Customer>
     */
    List<T> getCustomerByLastName(String lastName);

    /**
     * Get Customers by Full Name.
     *
     * @return List<T>
     */
    List<T> getCustomerByFullName(String firstName, String lastName);

    /**
     * Get Customers by Telephone number.
     *
     * @return List<T>
     */

    List<T> getCustomerByTelephone(String telephone);

    /**
     * Update a customer details.
     */
    void update(T newCustomer);

    /**
     * Add a customer in the system.
     */
    void add(T customer);

    /**
     * Delete a customer from the system.
     */
    void delete(T customer);

    /**
     * Get all Customers in the system.
     *
     * @return List<T>
     */
    List<T> getAll();


}
