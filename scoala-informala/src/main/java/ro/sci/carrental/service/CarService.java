package ro.sci.carrental.service;

import java.util.List;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepository;

/**
 * Service Interface for Car.
 *
 * @author flaviu.lupoian
 */
public interface CarService<T> {

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
    void update(T t);

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
     * @return List<Car>
     */
    List<T> findCarsByMakeAndModel(String make, String model);

    /**
     * Inject repository
     *
     * @param carRepository Car repository
     */
    void setCarRepository(CarRepository<Car> carRepository);
}
