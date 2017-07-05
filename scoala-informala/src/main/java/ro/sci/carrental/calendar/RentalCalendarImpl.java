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

        if (checkIfNotNull(car, interval)) {
            return car.getRentPrice().getValue() * interval.doubleValue();
        }

        return -1;
    }

    private <T extends Car, V extends Number> boolean checkIfNotNull(T car, V interval) {
        return car != null && car.getRentPrice() != null && interval != null;
    }

}