package ro.sci.carrental;

import ro.sci.carrental.calendar.RentalCalendarImpl;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.Price;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.*;
import ro.sci.carrental.simulations.*;

/**
 * <h1>RentACar Model</h1>
 * RentACar simulates a car rental business.
 * <p>
 * <h>
 * This is the main method which makes use of SimulateCars and SimulateCustomer classes to do search queries.
 *
 * @author Flaviu Lupoian
 * @version 1.2
 * @since 1.8
 */
public class Main {
    public static void main(String[] args) {
       Car mercedes = new Car();
       mercedes.setMake("Mercedes");
       mercedes.setRentPrice(new Price(65.00));
       Car bmw = new Car();
       bmw.setMake("Bmw");

       CarRepositoryImpl carRepository = new CarRepositoryImpl();
       carRepository.add(mercedes);
       carRepository.add(bmw);

       Customer customer1 = new Customer();
       customer1.setLastName("Cretu");
       Customer customer2 = new Customer();
       customer2.setLastName("Florea");

       CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
       customerRepository.add(customer1);
       customerRepository.add(customer2);

        //efectuam cautari masini
        SimulateCars<Car> simulateCars = new SimulateCars<>();
        simulateCars.searches(carRepository);

        //efectuam cautari clienti
        SimulateCustomer simulateCustomer = new SimulateCustomer();
        simulateCustomer.searches(customerRepository);

        //TEMA: stergem un Car din Repository
        carRepository.delete(mercedes);
        System.out.println("Lista masinilor din CarRepositoryImpl este: ");
        for (Object car : carRepository.getAll()) {
            System.out.println(car);
        }
        System.out.println("_____________________________________");

        RentalCalendarImpl rent = new RentalCalendarImpl();
        System.out.println(rent.calculateRentPrice(mercedes, 4));
    }
}
