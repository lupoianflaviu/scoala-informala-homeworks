package ro.sci.carrental.reader;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.domain.customer.CustomerAddress;
import ro.sci.carrental.domain.customer.PaymentMethod;

public class CustomerConvertor implements Convertor<Customer> {

    @Override
    public Customer convert(String convertedString) throws InvalidEntityException {
        String[] tokens = convertedString.split(",");

        if (tokens.length != 8) {
            throw new InvalidEntityException("Invalid Customer Description");
        }

        Customer customer = new Customer();
        customer.setId(Integer.valueOf(tokens[0]));
        customer.setFirstName(tokens[1]);
        customer.setLastName(tokens[2]);
        customer.setTelephone(tokens[3]);
        customer.setEmail(tokens[4]);
        customer.setCustomerAddress(new CustomerAddress(tokens[5], tokens[6]));
        customer.setPaymentMethod(PaymentMethod.valueOf(tokens[7].toUpperCase()));

        return customer;
    }
}
