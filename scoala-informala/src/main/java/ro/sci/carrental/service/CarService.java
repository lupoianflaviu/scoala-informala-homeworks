package ro.sci.carrental.service;

import java.util.List;

/**
 * Service Interface for Car.
 */
public interface CarService<T, V> {

    void add(T t);

    void delete(T t);

    void update(T t);

    /**
     * Find same make cars in system.
     * @param v Car make
     * @return List<Car>
     */
    List<T> findCarsByMake(V v);

    /**
     * Find same make and model cars in system.
     * @param make
     * @param model
     * @return List<Car>
     */
    List<T> findCarsByMakeAndModel(V make, V model);

    /**
     * Find same make, model, color and seats cars in system.
     * @param make
     * @param model
     * @param color
     * @param seats
     * @return List<Car>
     */
    List<T> findCarsByMakeModelColorAndSeats(V make, V model, V color, V seats);
}
