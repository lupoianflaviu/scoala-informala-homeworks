package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.FuelType;

import java.util.List;

/**
 * Repository interface for Car, this will help managing all persistence operations related to Car.
 *
 */
public interface CarRepository {
    /**
     * Get all cars in the system
     * @return List<Car>
     */
    <T> List<T> getAll();

    /**
     * Return all the cars of a certain maker
     * @param v
     * @return List<Car>
     */
    <T extends Car, V> List<T> getCarsByMake(V v);

    /**
     * Return all cars by fuel type
     * @param v
     * @return List<Car>
     */
    <T, V> List<T> getCarsByFuelType(V v);

    /**
     * Add a car in the system.
     * @param t
     */
    <T> void add(T t);

    /**
     * Add all cars in the system.
     * @param t
     */
    <T> void addAll(List<T> t);

    /**
     * Delete a car from the system.
     * @param t
     */
    <T> void delete(T t);

    /**
     * Updates car information in the system.
     * @param t
     */
    <T> void update(T t);


}
