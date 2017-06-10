package ro.sci.carrental;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.domain.Customer;
import ro.sci.carrental.domain.CustomerAddress;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.repository.CustomerRepositoryImpl;
import ro.sci.carrental.simulations.SimulateCars;
import ro.sci.carrental.simulations.SimulateCustomer;
import ro.sci.carrental.util.FuelType;
import ro.sci.carrental.util.PaymentMethod;
import ro.sci.carrental.util.VehicleCategory;

/**
 * <h1>RentACar Model</h1>
 * RentACar simulates a car rental business.
 * <p>
 * <h>
 * This is the main method which makes use of SimulateCars and SimulateCustomer classes to do search queries.
 *
 * @author Flaviu Lupoian
 * @version 1.1
 * @since 1.8
 */
public class Main {
    public static void main(String[] args) {
        // initializam masini
        Car mercedes = new Car("Mercedes", "e220d", 5.0f, "Black", 5, 4, true, true, true, FuelType.DIESEL, VehicleCategory.LIMOUSINE);
        Car bmw = new Car("BMW", "520d", 5.0f, "Silver", 5, 4, true, true, true, FuelType.GAS, VehicleCategory.SPORT);
        Car vw = new Car("Volkswagen", "Passat", 5.0f, "White", 5, 4, true, false, false, FuelType.GPL, VehicleCategory.SEDAN);

        CarRepositoryImpl carRepository = new CarRepositoryImpl();

        //introducem masini
        carRepository.add(mercedes);
        carRepository.add(bmw);
        carRepository.add(vw);

        //initializam clienti
        CustomerAddress customer1Address = new CustomerAddress("Str. Carpati Nr.1", "Cluj-Napoca", "Cluj", "Romania", "400270");
        CustomerAddress customer2Address = new CustomerAddress("Str. Bicegi Nr.1", "Oradea", "Bihor", "Romania", "400170");
        CustomerAddress customer3Address = new CustomerAddress("Str. Cucului Nr.1", "Zalau", "Salaj", "Romania", "400370");

        Customer customer1 = new Customer(1, "Dorel", "Cretu", "0727889900", "dorel@cretu.ro", customer1Address, PaymentMethod.CREDITCARD);
        Customer customer2 = new Customer(2, "Ionel", "Balanel", "0727770000", "ionel@balanel.ro", customer2Address, PaymentMethod.CASH);
        Customer customer3 = new Customer(3, "Vasile", "Blaga", "0727123456", "vasile@blaga.ro", customer3Address, PaymentMethod.PAYPAL);

        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

        //introducem clienti
        customerRepository.add(customer1);
        customerRepository.add(customer2);
        customerRepository.add(customer3);

        //efectuam cautari masini
        SimulateCars simulateCars = new SimulateCars();
        simulateCars.searches(carRepository);

        //efectuam cautari clienti
        SimulateCustomer simulateCustomer = new SimulateCustomer();
        simulateCustomer.searches(customerRepository);
    }
}
