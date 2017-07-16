package ro.sci.carrental.calendar;

/**
 * Interface for scheduling a rental.
 */
public interface RentalCalendar<Car, Number> {
    /**
     * Method calculateRentPrice calculates the rental price of a Car for a given number o rented days.
     * @param car
     * @param number
     * @return
     */
    double calculateRentPrice(Car car, Number number);
}
