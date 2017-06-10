package ro.sci.carrental.service;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.repository.CarRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CarService.
 *
 */
public class CarServiceImpl implements CarService {

    private CarRepositoryImpl carRepository;

    public CarServiceImpl(CarRepositoryImpl carRepository) {

        this.carRepository = carRepository;
    }

    /**
     * Public method findCarsByMake searches cars by make.
     *
     * @param make holds value of car make
     * @return list of found cars.
     */

    public List<Car> findCarsByMake(String make) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carRepository.getAll()) {
            if (car.getMake().equalsIgnoreCase(make)) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    /**
     * Public method findCarsByMakeAndModel searches cars by make and model.
     *
     * @param make  holds value of car make
     * @param model holds value f car model
     * @return list of found cars.
     */
    public List<Car> findCarsByMakeAndModel(String make, String model) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carRepository.getAll()) {
            if ((car.getModel().equalsIgnoreCase(model)) && (car.getMake().equalsIgnoreCase(make))) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    /**
     * Public method findCarsByMakeModelColorAndSeats searches cars by make, model, color, seats.
     *
     * @param make  value of car make
     * @param model value of car model
     * @param color value of car color
     * @param seats value of car seats
     * @return list of found cars
     */
    public List<Car> findCarsByMakeModelColorAndSeats(String make, String model, String color, int seats) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carRepository.getAll()) {
            if ((car.getModel().equalsIgnoreCase(model)) && (car.getMake().equalsIgnoreCase(make))
                    && (car.getColor().equalsIgnoreCase(color)) && (car.getSeats() == seats)) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    public CarRepositoryImpl getCarRepository() {
        return carRepository;
    }

}
