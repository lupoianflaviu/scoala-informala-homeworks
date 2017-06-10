package ro.sci.carrental.simulations;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.service.CarServiceImpl;

import java.util.List;

/**
 * Simulates car searches with different criteria.
 */
public class SimulateCars {
    public void searches(CarRepositoryImpl carRepository) {
        //cautarea tuturor masinilor
        System.out.println("Lista masinilor din CarRepositoryImpl este: ");
        for (Car car : carRepository.getAll()) {
            System.out.println(car.getMake());
        }
        System.out.println("_____________________________________");

        //cautare dupa marca
        CarServiceImpl search1 = new CarServiceImpl(carRepository);
        List<Car> foundCarsByMake = search1.findCarsByMake("BMW");

        System.out.println("Cautarea dupa Marca returneaza urmatoarele masini: ");
        for (Car car : foundCarsByMake) {
            System.out.println(car.getMake() + " " + car.getModel());
        }
        System.out.println("_____________________________________");

        //cautare dupa marca si model
        CarServiceImpl search2 = new CarServiceImpl(carRepository);
        List<Car> foundCarsByMakeAndModel = search2.findCarsByMakeAndModel("Mercedes", "e220d");

        System.out.println("Cautarea dupa Marca si Model returneaza urmatoarele masini: ");
        for (Car car : foundCarsByMakeAndModel) {
            System.out.println(car.getMake() + " " + car.getModel());
        }
        System.out.println("_____________________________________");

        //cautare dupa Marca, Model, Culoare si Locuri
        CarServiceImpl search3 = new CarServiceImpl(carRepository);
        List<Car> foundCarsByMultipleCategories = search3.findCarsByMakeModelColorAndSeats(
                "Volkswagen", "Passat", "White", 5);

        System.out.println("Cautarea dupa Marca, Model, Culoare si Locuri returneaza urmatoarele masini: ");
        for (Car car : foundCarsByMultipleCategories) {
            System.out.println(car.getMake() + " " + car.getModel());
        }
        System.out.println("######################################");
    }
}
