package ro.sci.carrental.service;

import java.util.List;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.repository.Repository;

/**
 * Implementation of CarService.
 */
public class CarServiceImpl implements CarService<Car> {

    private CarRepository<Car> carRepository;

    @Override
    public List<Car> getAll() {
        return this.carRepository.getAll();
    }

    @Override
    public void add(Car t) {
        this.carRepository.add(t);
    }

    @Override
    public void delete(Car t) {
        this.carRepository.delete(t);
    }

    @Override
    public void update(Car car) {
        this.carRepository.update(car);
    }

    /**
     * Public method findCarsByMake searches cars by make.
     *
     * @param make holds value of car make
     * @return list of found cars.
     */

    public List<Car> findCarsByMake(String make) {
        return this.carRepository.getCarsByMake(make);
    }

    /**
     * Public method findCarsByMakeAndModel searches cars by make and model.
     *
     * @param make  holds value of car make
     * @param model holds value f car model
     * @return list of found cars.
     */
    public List<Car> findCarsByMakeAndModel(String make, String model) {
        return this.carRepository.getCarsByMakeAndModel(make, model);
    }

    public Repository<Car> getCarRepository() {
        return carRepository;
    }

    @Override
    public void setCarRepository(CarRepository<Car> carRepository) {
        this.carRepository = carRepository;
    }
}
