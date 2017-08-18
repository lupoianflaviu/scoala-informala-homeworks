package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CarRepository.
 */
public class CarRepositoryImpl implements CarRepository<Car> {

    private List<Car> cars = new ArrayList<>();
    private int capacity = 5;


    public List<Car> getAll() {
        return cars;
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        List<Car> foundCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    @Override
    public List<Car> getCarsByMakeAndModel(String make, String model) {
        List<Car> foundCars = new ArrayList<>();

        for (Car car : cars) {
            if ((car.getModel().equalsIgnoreCase(String.valueOf(model)))
                    && (car.getMake().equalsIgnoreCase(String.valueOf(make)))) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    @Override
    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public void addAll() {
        this.cars.addAll(cars);
    }

    public void delete(Car car) {
        cars.removeIf(anotherCar -> anotherCar.equals(car));
    }

    public void update(Car car, Car oldCar) {
        cars.set(cars.indexOf(oldCar), car);
    }

    public void reserve(Car car) {
        car.isReserved(true);
    }

    public void freeup(Car car) {
        car.isReserved(false);
    }

    public int getCapacity() {
        return capacity;
    }
}
