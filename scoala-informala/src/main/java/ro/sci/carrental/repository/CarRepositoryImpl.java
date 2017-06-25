package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CarRepository.
 *
 */
public class CarRepositoryImpl implements CarRepository {

    private List<Car> cars = new ArrayList<>();


    public List<Car> getAll() {
        return cars;
    }

    @Override
    public <T, V> List<T> getCarsByFuelType(V fuelType) {
        List<T> seachedCars = new ArrayList<>();

        for (ro.sci.carrental.domain.car.Car car: cars) {
            if (cars.contains(fuelType)) {
                seachedCars.add((T) car);
            }

        }

        return seachedCars;
    }

    public <T extends Car, V> List<T> getCarsByMake(V make) {
        List<T> seachedCars = new ArrayList<>();

        for (ro.sci.carrental.domain.car.Car car: cars) {
            if (cars.contains(car.getMake())) {
                seachedCars.add((T) car);
            }

        }

        return seachedCars;
    }


    public <T> void add(T car) {
        cars.add((Car) car);
    }

    public <T> void addAll(List<T> cars) {
        cars.addAll(cars);
    }

    public <T> void delete(T car) {
        //safe way do delete in a List
        cars.removeIf(anotherCar -> anotherCar.equals(car));
    }

    public <T> void update(T car) {
        cars.set(cars.indexOf(car), (Car) car);
    }
}
