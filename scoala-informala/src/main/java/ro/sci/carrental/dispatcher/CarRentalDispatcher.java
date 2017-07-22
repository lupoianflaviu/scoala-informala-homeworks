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
                notifyAll();
            }
        }
    }

    public void rent(Car car) {

        while (true) {
            synchronized (this) {

                while (carRepository.getAll().size() == carRepository.getCapacity()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        LOGGER.log(Level.INFO, e.getMessage());
                    }
                }
                carRepository.delete(car);
                notifyAll();
            }
        }
    }
}
