package ro.sci.carrental.simulations;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.service.CarServiceImpl;

import java.util.List;

/**
 * Simulates car searches with different criteria.
 */
public class SimulateCars<T extends Car> {
    public void searches(CarRepositoryImpl carRepository) {

        System.out.println("Lista masinilor din CarRepositoryImpl este: ");

        for (Object car : carRepository.getAll()) {
            System.out.println(car);
        }
        System.out.println("_____________________________________");
    }
}
