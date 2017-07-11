package ro.sci.carrental.simulations;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.service.CarServiceImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simulates car searches with different criteria.
 */
public class SimulateCars<T extends Car> {
    public void searches(CarRepositoryImpl carRepository) {
        final Logger LOGGER = Logger.getLogger("RentingSimulation");
        LOGGER.log(Level.INFO, "Lista initiala a masinilor din CarRepositoryImpl este: {0}\n", carRepository.getAll());
    }
}
