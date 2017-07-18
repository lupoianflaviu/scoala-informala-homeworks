package ro.sci.carrental.domain.customer;

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
    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (telephone != null ? !telephone.equals(customer.telephone) : customer.telephone != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (customerAddress != null ? !customerAddress.equals(customer.customerAddress) : customer.customerAddress != null)
            return false;
        return paymentMethod == customer.paymentMethod;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (customerAddress != null ? customerAddress.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(id).append(",").append(firstName).append(",").append(lastName).append(",")
                .append(telephone).append(",").append(email).append(",").append(customerAddress).append(",")
                .append(paymentMethod);
        return result.toString();
    }
}
