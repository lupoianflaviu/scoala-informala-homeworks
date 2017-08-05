package ro.sci.carrental.dispatcher;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.repository.CarRepositoryImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CarRentalDispatcher {
    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    CarRepository<Car> carRepository = new CarRepositoryImpl();

    public void returnCar(Car car) {

        while (true) {
            synchronized (this) {

                while (carRepository.getAll().size() == carRepository.getCapacity()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        LOGGER.log(Level.INFO, e.getMessage());
                    }
                }
                carRepository.add(car);
                LOGGER.log(Level.INFO, car + " returned");
                notifyAll();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    LOGGER.log(Level.INFO, e.getMessage());
                }
            }
        }
    }

    public void rent(Car car) {

        while (true) {
            synchronized (this) {

                while (carRepository.getAll().size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        LOGGER.log(Level.INFO, e.getMessage());
                    }
                }
                carRepository.delete(car);
                LOGGER.log(Level.INFO, car + " rented");
                notifyAll();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    LOGGER.log(Level.INFO, e.getMessage());
                }
            }
        }
    }
}
