package ro.sci.carrental;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.reader.InvalidEntityException;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.repository.CustomerRepositoryImpl;
import ro.sci.carrental.service.CarService;
import ro.sci.carrental.service.CarServiceImpl;
import ro.sci.carrental.service.CustomerService;
import ro.sci.carrental.service.CustomerServiceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>RentACar Model</h1>
 * RentACar simulates a car rental business.
 * <p>
 * <h>
 * This is the main method which makes use of SimulateCars and SimulateCustomer classes to do search queries.
 *
 * @author Flaviu Lupoian
 * @version 1.3
 * @since 1.8
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    public static void main(String[] args) throws InvalidEntityException, InterruptedException {

        CarService<Car> carService = new CarServiceImpl(new CarRepositoryImpl());
        LOGGER.log(Level.INFO, "\nLista masinilor este: \n" + carService.findCarsByMake("Bmw").toString());
//        LOGGER.log(Level.INFO, "\nLista masinilor din Repository este: \n" + carService.getAll().toString());

        CustomerService<Customer> customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());
//        customerService.addAll();
        LOGGER.log(Level.INFO, "\nLista clientilor din Repository este: \n" + customerService.getAll().toString());

        LOGGER.log(Level.INFO, customerService.findCustomerByLastName("cretu").toString());
        LOGGER.log(Level.INFO, customerService.findCustomerByTelephone("07277744888").toString());
        LOGGER.log(Level.INFO, customerService.findCustomerByFullName("florin", "salam").toString());
    }
}
