package ro.sci.carrental.calendar;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.Price;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by CCA on 05/07/2017.
 */
public class RentalCalendarTest {

    @Test
    public void testCalculateRentPrice() {
        Car audi = new Car();
        audi.setMake("Audi");
        audi.setRentPrice(new Price(50.00));

        RentalCalendarImpl result = new RentalCalendarImpl();
        double actual = result.calculateRentPrice(audi, 5);

        assertEquals(250, actual, 0);
    }

    @Test
    public void testCalculateRentPriceWithNullPrice() {
        Car vw = new Car();
        vw.setMake("vw");

        RentalCalendarImpl result = new RentalCalendarImpl();
        double actual = result.calculateRentPrice(vw, 5);

        //if Car Renting Price is null return -1
        assertEquals(-1, actual, 0);
    }

}