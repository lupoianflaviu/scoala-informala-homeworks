package ro.sci.carrental.service;

import java.util.List;

/**
 * Service Interface for Car.
 */
public interface CarService<T> {

    void addAll();

    List<T> getAll();

    /**
     * Add to repository
     *
     * @param t generic type
     */
    void add(T t);

    /**
     * Delete from repository
     *
     * @param t generic type
     */
    void delete(T t);

    /**
     * Update element in repository
     *
     * @param t generic type
     */
    void update(T t, T v);

    /**
     * Find same make cars in system.
     *
     * @param v Car make
     * @return List<Car>
     */
    List<T> findCarsByMake(String v);

    /**
     * Find same make and model cars in system.
     *
     * @param make
     * @param model
     * @return List<Car>
     */
    List<T> findCarsByMakeAndModel(String make, String model);
}
