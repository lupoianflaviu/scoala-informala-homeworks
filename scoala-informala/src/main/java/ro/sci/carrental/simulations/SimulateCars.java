package ro.sci.carrental.simulations;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.service.CarServiceImpl;

import java.util.List;

/**
 * Simulates car searches with different criteria.
 */
public class SimulateCars {
    public void searches(CarRepositoryImpl carRepository) {
        System.out.println("Lista masinilor din CarRepositoryImpl este: ");
        for (Car car : carRepository.getAll()) {
            System.out.println(car.getMake());
        }
        System.out.println("_____________________________________");
    }
}
