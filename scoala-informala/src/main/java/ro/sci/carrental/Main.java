package ro.sci.carrental;

import java.util.logging.Level;
import java.util.logging.Logger;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.repository.CustomerRepositoryImpl;
import ro.sci.carrental.service.CarService;
import ro.sci.carrental.service.CarServiceImpl;
import ro.sci.carrental.service.CustomerService;
import ro.sci.carrental.service.CustomerServiceImpl;

/**
 * <h1>RentACar Model</h1> RentACar simulates a car rental business.
 *
 * @author Flaviu Lupoian
 * @version 1.5
 * @since 1.8
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    public static void main(String[] args) {

        CarService<Car> carService = new CarServiceImpl();
        carService.setCarRepository(new CarRepositoryImpl());

        LOGGER.log(Level.INFO, "\nLista masinilor este: \n" + carService.findCarsByMake("Test")
                                                                        .toString());
        LOGGER.log(Level.INFO, "\nLista masinilor din Repository este: \n" + carService.getAll()
                                                                                       .toString());
        CustomerService<Customer> customerService = new CustomerServiceImpl();
        customerService.setCustomerRepository(new CustomerRepositoryImpl());
        LOGGER.log(Level.INFO, "\nLista clientilor din Repository este: \n" + customerService.getAll()
                                                                                             .toString());

        LOGGER.log(Level.INFO, customerService.findCustomerByLastName("cretu")
                                              .toString());
        LOGGER.log(Level.INFO, customerService.findCustomerByTelephone("07277744888")
                                              .toString());
        LOGGER.log(Level.INFO, customerService.findCustomerByFullName("florin", "salam")
                                              .toString());
    }
}
