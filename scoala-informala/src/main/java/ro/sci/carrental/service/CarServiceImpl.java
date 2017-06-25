package ro.sci.carrental.service;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CarService.
 */
public class CarServiceImpl<T extends Car, V> implements CarService<T, V> {

    private CarRepositoryImpl<T, V> carRepository;

    public CarServiceImpl(CarRepositoryImpl carRepository) {

        this.carRepository = carRepository;
    }

    /**
     * Public method findCarsByMake searches cars by make.
     *
     * @param make holds value of car make
     * @return list of found cars.
     */

    public List<T> findCarsByMake(V make) {
        List<T> foundCars = new ArrayList<>();

        for (T car : carRepository.getAll()) {
            if (car.getMake().equalsIgnoreCase(String.valueOf(make))) {
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
    public List<T> findCarsByMakeAndModel(V make, V model) {
        List<T> foundCars = new ArrayList<>();

        for (T car : carRepository.getAll()) {
            if ((car.getModel().equalsIgnoreCase(String.valueOf(model)))
                    && (car.getMake().equalsIgnoreCase(String.valueOf(make)))) {
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
    public List<T> findCarsByMakeModelColorAndSeats(V make, V model, V color, V seats) {
        List<T> foundCars = new ArrayList<>();

        for (T car : carRepository.getAll()) {
            if ((car.getModel().equalsIgnoreCase(String.valueOf(model)))
                    && (car.getMake().equalsIgnoreCase(String.valueOf(make)))
                    && (car.getColor().equalsIgnoreCase(String.valueOf(color)))
                    && (car.getSeats() == (Integer) seats)) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    public CarRepositoryImpl<T, V> getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepositoryImpl<T, V> carRepository) {
        this.carRepository = carRepository;
    }
}
