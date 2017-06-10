package ro.sci.carrental.calendar;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.customer.Customer;

/**
 * Interface for scheduling a rental.
 */
public interface RentalCalendar {
    /**
     * Method pickupTime() simulates a car pickup by a client
     * @param car the object car in use
     * @param customer the customer
     * @param date date and time of pickup
     */
    void pickupTime(Car car, Customer customer, String date);
    /**
     * Method returnTime() simulates a return of a car previously picked up
     * @param car object of car in use
     * @param customer the custumer
     * @param date date and time of return
     */
    void returnTime(Car car, Customer customer, String date);
}
