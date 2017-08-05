package ro.sci.carrental.calendar;


import ro.sci.carrental.domain.car.Car;

/**
 * Implementation of calendar Interface
 */
public class RentalCalendarImpl<T extends Car, V> implements RentalCalendar<Car, Integer> {
    private Integer pickupTime;
    private Integer returnTime;
    private Integer interval;

    public RentalCalendarImpl(Integer pickupTime, Integer returnTime) {
        this.pickupTime = pickupTime;
        this.returnTime = returnTime;
        this.interval = this.returnTime - this.pickupTime;
    }

    public double calculateRentPrice(Car car, Integer interval) {
        double result;
        interval = this.interval;

        try {

            result = car.getRentPrice().getValue() * interval.doubleValue();

            return result;
        } catch (NullPointerException e) {

            System.err.println("Check for null " + e.getMessage());
            result = -1;

            return result;
        }
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Integer pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Integer getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Integer returnTime) {
        this.returnTime = returnTime;
    }
}