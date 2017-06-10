package ro.sci.carrental.calendar;


import ro.sci.carrental.domain.Car;
import ro.sci.carrental.domain.Customer;

/**
 * Implementation of calendar Interface
 *
 */
public class RentalCalendarImpl implements RentalCalendar{



    public void pickupTime(Car car, Customer customer, String date) {
        System.out.println("Automobilul " + car.getMake() + " " + car.getModel()+ " va fi ridicat de catre clientul " +
                customer.getFirstName() + " " + customer.getLastName() + " la data si ora " + date);

    }


    public void returnTime(Car car, Customer customer, String date) {
        System.out.println("Automobilul " + car.getMake() + " " + car.getModel()+ " va fi inapoiat de catre clientul " +
                customer.getFirstName() + " " + customer.getLastName() + " la data si ora " + date);
    }
}