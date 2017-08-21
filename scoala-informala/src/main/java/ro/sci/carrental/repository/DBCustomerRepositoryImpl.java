package ro.sci.carrental.repository;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.domain.customer.CustomerAddress;
import ro.sci.carrental.domain.customer.PaymentMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBCustomerRepositoryImpl extends BaseDBRepository implements CustomerRepository<Customer> {

    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    private List<Customer> customers = new ArrayList<>();

    @Override
    public List<Customer> getAll() {
        try (Connection conn = newConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(
                     "select * from outcustomers")) {

            while (rs.next()) {

                Customer customer = new Customer();

                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setCustomerAddress(new CustomerAddress
                        (rs.getString("streetaddress"), rs.getString("city")));
                customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString("paymentmethod")));
                customers.add(customer);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        return customers;
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName) {

        List<Customer> searchedCustomers = new ArrayList<>();

        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement("select * from outcustomers where lastname=?")) {

            stm.setString(1, lastName);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();

                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setCustomerAddress(new CustomerAddress
                        (rs.getString("streetaddress"), rs.getString("city")));
                customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString("paymentmethod")));

                searchedCustomers.add(customer);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        return searchedCustomers;
    }

    @Override
    public List<Customer> getCustomerByFullName(String firstName, String lastName) {
        List<Customer> searchedCustomers = new ArrayList<>();

        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement("SELECT * FROM outcustomers WHERE firstname=? AND lastname=?")) {

            stm.setString(1, firstName);
            stm.setString(2, lastName);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();

                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setCustomerAddress(new CustomerAddress
                        (rs.getString("streetaddress"), rs.getString("city")));
                customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString("paymentmethod")));

                searchedCustomers.add(customer);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        return searchedCustomers;
    }

    @Override
    public List<Customer> getCustomerByTelephone(String telephone) {
        List<Customer> searchedCustomers = new ArrayList<>();

        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement("SELECT * FROM outcustomers WHERE telephone=?")) {

            stm.setString(1, telephone);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {


                Customer customer = new Customer();

                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setCustomerAddress(new CustomerAddress
                        (rs.getString("streetaddress"), rs.getString("city")));
                customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString("paymentmethod")));

                searchedCustomers.add(customer);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        return searchedCustomers;
    }

    @Override
    public void add(Customer customer) {

        try (Connection conn = newConnection();
             PreparedStatement stm =
                     conn.prepareStatement("INSERT INTO outcustomers(firstname,lastname,telephone,email,streetaddress,city,paymentmethod) " +
                             "values(?,?,?,?,?,?,?)")) {

            conn.setAutoCommit(false);
            stm.setString(1, customer.getFirstName());
            stm.setString(2, customer.getLastName());
            stm.setString(3, customer.getTelephone());
            stm.setString(4, customer.getEmail());
            stm.setString(5, customer.getCustomerAddress().getStreetAddress());
            stm.setString(6, customer.getCustomerAddress().getCity());
            stm.setString(7, customer.getPaymentMethod().toString());

            stm.execute();
            conn.commit();
            conn.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        LOGGER.log(Level.INFO, "SCRIEREA IN TABELUL OUTCUSTOMERS S-A INCHEIAT.");

    }

    @Override
    public void addAll() {
        try (Connection conn = newConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(
                     "select firstname,lastname,telephone,email,streetaddress,city,paymentmethod from customers")) {

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setCustomerAddress(new CustomerAddress
                        (rs.getString("streetaddress"), rs.getString("city")));
                customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString("paymentmethod")));

                add(customer);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

    }

    @Override
    public void delete(Customer customer) {
        //delete by last name
        try (Connection conn = newConnection();
             PreparedStatement stm =
                     conn.prepareStatement("DELETE FROM outcars where lastname=?")) {

            stm.setString(1, customer.getLastName());
            stm.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        LOGGER.log(Level.INFO, "STERGEREA CLIENTULUI DIN TABELUL OUTCUSTOMERS S-A INCHEIAT.");
    }

    @Override
    public void update(Customer newCustomer, Customer oldCustomer) {
        try (Connection conn = newConnection();
             PreparedStatement stm =
                     conn.prepareStatement("SET firstname=?, lastname=?, telephone=?, email=?, streetaddress=?, city=?, paymentmethod=? "
                             + "WHERE lastname = ?")) {

            stm.setString(1, newCustomer.getFirstName());
            stm.setString(2, newCustomer.getLastName());
            stm.setString(3, newCustomer.getTelephone());
            stm.setString(4, newCustomer.getEmail());
            stm.setString(5, newCustomer.getCustomerAddress().getStreetAddress());
            stm.setString(6, newCustomer.getCustomerAddress().getCity());
            stm.setString(7, newCustomer.getPaymentMethod().toString());

            stm.setString(14, oldCustomer.getLastName());

            stm.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        LOGGER.log(Level.INFO, "Modificarea clientului s-a terminat");
    }
}
