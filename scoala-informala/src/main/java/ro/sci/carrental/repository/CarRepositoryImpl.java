package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CarRepository.
 */
public class CarRepositoryImpl<T extends Car, V> implements CarRepository<T, V> {

    private List<T> cars = new ArrayList<>();


    public List<T> getAll() {
        return cars;
    }

    @Override
    public List<T> getCarsByFuelType(V fuelType) {
        List<T> seachedCars = new ArrayList<>();

        for (T car : cars) {
            if (cars.contains(fuelType)) {
                seachedCars.add(car);
            }

        }

        return seachedCars;
    }

    public List<T> getCarsByMake(V make) {
        List<T> seachedCars = new ArrayList<>();

        for (T car : cars) {
            if (cars.contains(car.getMake())) {
                seachedCars.add(car);
            }

        }

        return seachedCars;
    }


    public void add(T car) {
        cars.add(car);
    }

    public void addAll(List<T> cars) {
        this.cars.addAll(cars);
    }

    public void delete(T car) {
        //safe way do delete in a List
        cars.removeIf(anotherCar -> anotherCar.equals(car));
    }

    public void update(T car) {
        cars.set(cars.indexOf(car), car);
    }
}
