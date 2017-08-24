package ro.sci.carrental.repository;

import java.util.List;

import ro.sci.carrental.domain.car.Car;

/**
 * Repository interface for Car, this will help managing all persistence operations related to Car.
 */
public interface CarRepository<T extends Car> extends Repository<T> {
    /**
     * Get all cars in the system
     *
     * @return List<Car>
     */
    List<T> getAll();

    /**
     * Return all the cars of a certain maker
     *
     * @return List<Car>
     */
    List<T> getCarsByMake(String v);

    /**
     * Return all cars by fuel type
     *
     * @return List<Car>
     */
    List<T> getCarsByMakeAndModel(String make, String model);

    /**
     * Add a car in the system.
     */
    void add(T t);

    /**
     * Delete a car from the system.
     */
    void delete(T t);

    /**
     * Updates car information in the system.
     */
    void update(T t);
}
