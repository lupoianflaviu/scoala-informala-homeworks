package ro.sci.carrental.calendar;

/**
 * Interface for scheduling a rental.
 */
public interface RentalCalendar<T, V> {
    /**
     * Method calculateRentPrice calculates the rental price of a Car for a given number o rented days.
     * @param t Type Car representing the rented car
     * @param v Type Number representing Renting interval
     * @return
     */
    double calculateRentPrice(T t, V v);
}
