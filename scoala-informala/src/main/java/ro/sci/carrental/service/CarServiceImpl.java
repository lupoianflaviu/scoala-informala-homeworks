package ro.sci.carrental.service;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CarService.
 */
public class CarServiceImpl implements CarService<Car> {

    private CarRepository<Car> carRepository;

    public CarServiceImpl(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    @Override
    public void add(Car t) {
        this.carRepository.add(t);
    }

    @Override
    public void delete(Car t) {
        this.carRepository.delete(t);
    }

    @Override
    public void update(Car t) {
        this.carRepository.update(t);
    }

    /**
     * Public method findCarsByMake searches cars by make.
     *
     * @param make holds value of car make
     * @return list of found cars.
     */

    public List<Car> findCarsByMake(String make) {
        List<Car> foundCars = new ArrayList<>();

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
        List<Car> foundCars = new ArrayList<>();

        for (Car car : carRepository.getAll()) {
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
    public List<Car> findCarsByMakeModelColorAndSeats(String make, String model, String color, String seats) {
        List<Car> foundCars = new ArrayList<>();

        for (Car car : carRepository.getAll()) {
            if ((car.getModel().equalsIgnoreCase(model))
                    && (car.getMake().equalsIgnoreCase(make))
                    && (car.getColor().equalsIgnoreCase(color))
                    && (car.getSeats() == Integer.valueOf(seats))) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    public CarRepository<Car> getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository<Car> carRepository) {
        this.carRepository = carRepository;
    }
}
