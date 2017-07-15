package ro.sci.carrental.simulations;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simulates car searches with different criteria.
 */
public class SimulateCars<T extends Car> {
    public void searches(CarRepository carRepository) {
        final Logger LOGGER = Logger.getLogger("RentingSimulation");
        LOGGER.log(Level.INFO, "Lista initiala a masinilor din CarRepositoryImpl este: {0}\n", carRepository.getAll());
    }
}
