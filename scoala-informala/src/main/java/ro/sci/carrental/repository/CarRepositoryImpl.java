package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.FuelType;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CarRepository.
 */
public class CarRepositoryImpl<T extends Car, V> implements CarRepository<Car, String> {

    private List<Car> cars = new ArrayList<>();


    public List<Car> getAll() {
        return cars;
    }

    @Override
    public List<Car> getCarsByFuelType(String fuelType) {
        List<Car> seachedCars = new ArrayList<>();

        for (Car car : cars) {
            if (cars.contains(fuelType)) {
                seachedCars.add(car);
            }

        }

        return seachedCars;
    }

    public List<Car> getCarsByMake(String make) {
        List<Car> seachedCars = new ArrayList<>();

        for (Car car : cars) {
            if (cars.contains(car.getMake())) {
                seachedCars.add(car);
            }

        }

        return seachedCars;
    }


    public void add(Car car) {
        cars.add(car);
    }

    public void addAll(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public void delete(Car car) {
        cars.removeIf(anotherCar -> anotherCar.equals(car));
    }

    public void update(Car car) {
        cars.set(cars.indexOf(car), car);
    }
}
