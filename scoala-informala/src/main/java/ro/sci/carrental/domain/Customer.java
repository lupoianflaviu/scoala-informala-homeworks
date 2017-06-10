package ro.sci.carrental.domain;

import ro.sci.carrental.util.PaymentMethod;

/**
 * Customer Class contains customers blueprint.
 *
 * @author Flaviu Lupoian
 * @version 1.1
 * @since 1.8
 */
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private CustomerAddress customerAddress;
    private PaymentMethod paymentMethod;

    /**
     * Default Constructor
     */
    public Customer() {}

    /**
     * Constructor for all fields
     * @param id id
     * @param firstName First Name
     * @param lastName Last Name
     * @param telephone Telephone No.
     * @param email email address
     * @param customerAddress Customer address
     * @param paymentMethod Payment method
     */
    public Customer(int id, String firstName, String lastName, String telephone, String email, CustomerAddress customerAddress, PaymentMethod paymentMethod) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.customerAddress = customerAddress;
        this.paymentMethod = paymentMethod;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
