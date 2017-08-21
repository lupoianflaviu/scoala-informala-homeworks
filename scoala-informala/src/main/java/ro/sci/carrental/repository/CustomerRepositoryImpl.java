package ro.sci.carrental.repository;

import ro.sci.carrental.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Customer Repository.
 */
public class CustomerRepositoryImpl implements CustomerRepository<Customer> {

    private List<Customer> customers = new ArrayList<Customer>();

    public List<Customer> getAll() {
        return customers;
    }

    public List<Customer> getCustomerByLastName(String lastName) {
        List<Customer> foundCustomers = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getLastName().equalsIgnoreCase(lastName)) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }

    public List<Customer> getCustomerByFullName(String firstName, String lastName) {
        List<Customer> foundCustomers = new ArrayList<>();

        for (Customer customer : customers) {
            if ((customer.getFirstName().equalsIgnoreCase(firstName))
                    && (customer.getLastName().equalsIgnoreCase(lastName))) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }

    public List<Customer> getCustomerByTelephone(String telephone) {
        return null;
    }


    @Override
    public void addAll() {

    }

    public void add(Customer customer) {
        customers.add(customer);
    }

//    public void addAll(List<Customer> customers) {
//        customers.addAll(customers);
//    }

    public void delete(Customer customer) {
        customers.removeIf(anotherCustomer -> anotherCustomer.equals(customer));
    }

    @Override
    public void update(Customer newCustomer, Customer oldCustomer) {

    }

//    public void update(Customer customer) {
//        customers.set(customers.indexOf(customer), customer);
//    }


}
