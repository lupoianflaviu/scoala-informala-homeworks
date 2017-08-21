package ro.sci.carrental.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.domain.customer.CustomerAddress;
import ro.sci.carrental.domain.customer.PaymentMethod;

public class CustomerRepositoryImpl extends BaseDBRepository implements CustomerRepository<Customer> {

    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");
    private static final String SELECT_FROM_OUTCUSTOMERS_WHERE_LASTNAME = "select * from outcustomers where lastname=?";
    private static final String SELECT_ALL_FROM_OUTCUSTOMERS = "select * from outcustomers";
    private static final String SELECT_ALL_FROM_OUTCUSTOMERS_WHERE_FIRSTNAME_AND_LASTNAME = "SELECT * FROM outcustomers WHERE firstname=? AND lastname=?";
    private static final String SELECT_FROM_OUTCUSTOMERS_WHERE_TELEPHONE = "SELECT * FROM outcustomers WHERE telephone=?";
    private static final String INSERT_INTO_OUTCUSTOMERS_VALUES =
            "INSERT INTO outcustomers(firstname,lastname,telephone,email,streetaddress,city,paymentmethod) " + "values(?,?,?,?,?,?,?)";
    private static final String DELETE_FROM_OUTCARS_WHERE_ID = "DELETE FROM outcars where id=?";
    private static final String SET_WHERE_ID = "SET firstname=?, lastname=?, telephone=?, email=?, streetaddress=?, city=?, paymentmethod=? " + "WHERE id = ?";
    private static final String DATABASE_ERROR = "Database error!";
    private static final String EXCEPTION_THROWN = "Exception thrown";
    private static final String UPDATE_FINISHED = "Modificarea clientului s-a terminat";
    private static final String DELETE_COMPLETE = "CUSTOMER DELETION COMPLETE";
    private static final String WRITING_COMPLETE = "WRITING IN OUTCUSTOMERS HAS FINISHED.";
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "lastname";
    private static final String TELEPHONE = "telephone";
    private static final String EMAIL = "email";
    private static final String STREET_ADDRESS = "streetaddress";
    private static final String CITY = "city";
    private static final String PAYMENTMETHOD = "paymentmethod";
    private static final String ID = "id";

    @Override
    public List<Customer> getCustomerByLastName(String lastName) {

        List<Customer> searchedCustomers = new ArrayList<>();

        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(SELECT_FROM_OUTCUSTOMERS_WHERE_LASTNAME)) {

            stm.setString(1, lastName);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();
                customer.setId(rs.getInt(ID));
                customer.setFirstName(rs.getString(FIRST_NAME));
                customer.setLastName(rs.getString(LAST_NAME));
                customer.setTelephone(rs.getString(TELEPHONE));
                customer.setEmail(rs.getString(EMAIL));
                customer.setCustomerAddress(new CustomerAddress(rs.getString(STREET_ADDRESS), rs.getString(CITY)));
                customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString(PAYMENTMETHOD)));

                searchedCustomers.add(customer);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        return searchedCustomers;
    }

    @Override
    public List<Customer> getCustomerByFullName(String firstName, String lastName) {
        List<Customer> searchedCustomers = new ArrayList<>();

        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(SELECT_ALL_FROM_OUTCUSTOMERS_WHERE_FIRSTNAME_AND_LASTNAME)) {

            stm.setString(1, firstName);
            stm.setString(2, lastName);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();
                customer.setId(rs.getInt(ID));
                customer.setFirstName(rs.getString(FIRST_NAME));
                customer.setLastName(rs.getString(LAST_NAME));
                customer.setTelephone(rs.getString(TELEPHONE));
                customer.setEmail(rs.getString(EMAIL));
                customer.setCustomerAddress(new CustomerAddress(rs.getString(STREET_ADDRESS), rs.getString(CITY)));
                customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString(PAYMENTMETHOD)));

                searchedCustomers.add(customer);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        return searchedCustomers;
    }

    @Override
    public List<Customer> getCustomerByTelephone(String telephone) {
        List<Customer> searchedCustomers = new ArrayList<>();

        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(SELECT_FROM_OUTCUSTOMERS_WHERE_TELEPHONE)) {

            stm.setString(1, telephone);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {


                Customer customer = new Customer();
                customer.setId(rs.getInt(ID));
                customer.setFirstName(rs.getString(FIRST_NAME));
                customer.setLastName(rs.getString(LAST_NAME));
                customer.setTelephone(rs.getString(TELEPHONE));
                customer.setEmail(rs.getString(EMAIL));
                customer.setCustomerAddress(new CustomerAddress(rs.getString(STREET_ADDRESS), rs.getString(CITY)));
                customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString(PAYMENTMETHOD)));

                searchedCustomers.add(customer);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        return searchedCustomers;
    }

    @Override
    public void update(Customer newCustomer) {
        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(SET_WHERE_ID)) {

            stm.setString(1, newCustomer.getFirstName());
            stm.setString(2, newCustomer.getLastName());
            stm.setString(3, newCustomer.getTelephone());
            stm.setString(4, newCustomer.getEmail());
            stm.setString(5, newCustomer.getCustomerAddress()
                                        .getStreetAddress());
            stm.setString(6, newCustomer.getCustomerAddress()
                                        .getCity());
            stm.setString(7, newCustomer.getPaymentMethod()
                                        .toString());

            stm.setInt(8, newCustomer.getId());

            stm.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        LOGGER.log(Level.INFO, UPDATE_FINISHED);
    }

    @Override
    public void add(Customer customer) {

        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(INSERT_INTO_OUTCUSTOMERS_VALUES)) {

            stm.setString(1, customer.getFirstName());
            stm.setString(2, customer.getLastName());
            stm.setString(3, customer.getTelephone());
            stm.setString(4, customer.getEmail());
            stm.setString(5, customer.getCustomerAddress()
                                     .getStreetAddress());
            stm.setString(6, customer.getCustomerAddress()
                                     .getCity());
            stm.setString(7, customer.getPaymentMethod()
                                     .toString());

            stm.execute();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        LOGGER.log(Level.INFO, WRITING_COMPLETE);

    }

    @Override
    public void delete(Customer customer) {
        //delete by id
        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(DELETE_FROM_OUTCARS_WHERE_ID)) {

            stm.setInt(1, customer.getId());
            stm.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        LOGGER.log(Level.INFO, DELETE_COMPLETE);
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();

        try (Connection conn = newConnection(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(SELECT_ALL_FROM_OUTCUSTOMERS)) {

            while (rs.next()) {

                Customer customer = new Customer();
                customer.setId(rs.getInt(ID));
                customer.setFirstName(rs.getString(FIRST_NAME));
                customer.setLastName(rs.getString(LAST_NAME));
                customer.setTelephone(rs.getString(TELEPHONE));
                customer.setEmail(rs.getString(EMAIL));
                customer.setCustomerAddress(new CustomerAddress(rs.getString(STREET_ADDRESS), rs.getString(CITY)));
                customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString(PAYMENTMETHOD)));
                customers.add(customer);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        return customers;
    }
}
