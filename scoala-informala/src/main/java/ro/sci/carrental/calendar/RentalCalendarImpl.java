package ro.sci.carrental.calendar;


import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.customer.Customer;

/**
 * Implementation of calendar Interface
 */
public class RentalCalendarImpl implements RentalCalendar {


    public void pickupTime(Car car, Customer customer, String date) {
        System.out.println("Automobilul " + car.getMake() + " va fi ridicat de catre clientul "
                + customer.getLastName() + " la data si ora " + date);
        car.setReserved(true);
    }


    public void returnTime(Car car, Customer customer, String date) {
        System.out.println("Automobilul " + car.getMake() + " va fi inapoiat de catre clientul " +
                customer.getLastName() + " la data si ora " + date);
        car.setReserved(false);
    }

    public <T extends Car, V extends Number> double calculateRentPrice(T car, V interval) {
        double result = 0;

        try {
            result = car.getRentPrice().getValue() * interval.doubleValue();

            return result;
        } catch (NullPointerException e) {
            System.err.println("Check for null " + e.getMessage());
            result = -1;

            return result;
        }
    }
}