package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;

import java.util.List;

/**
 * Repository interface for Car, this will help managing all persistence operations related to Car.
 */
public interface CarRepository<T extends Car> {
    /**
     * Get all cars in the system
     *
     * @return List<Car>
     */
    List<T> getAll();

    /**
     * Return all the cars of a certain maker
     *
     * @param v
     * @return List<Car>
     */
    List<T> getCarsByMake(String v);

    /**
     * Return all cars by fuel type
     *
     * @param v
     * @return List<Car>
     */
    List<T> getCarsByFuelType(String v);

    /**
     * Add a car in the system.
     *
     * @param t
     */
    void add(T t);

    /**
     * Add all cars in the system.
     *
     * @param t
     */
    void addAll(List<T> t);

    /**
     * Delete a car from the system.
     *
     * @param t
     */
    void delete(T t);

    /**
     * Updates car information in the system.
     *
     * @param t
     */
    void update(T t);


}
