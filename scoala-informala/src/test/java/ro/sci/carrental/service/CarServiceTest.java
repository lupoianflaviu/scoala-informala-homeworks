package ro.sci.carrental.service;

import org.junit.Before;
import org.junit.Test;
import ro.sci.carrental.domain.car.*;
import ro.sci.carrental.repository.DBCarRepositoryImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CarServiceTest {
    private DBCarRepositoryImpl carRepository = new DBCarRepositoryImpl();
    private CarService<Car> carService = new CarServiceImpl(carRepository);
    private Car car = new Car();
    private Car car2 = new Car();

    @Before
    public void setUp() throws Exception {

        car.setMake("Trabant");
        car.setModel("Vechi");
        car.setSize(7);
        car.setColor("color");
        car.setSeats(5);
        car.setDoors(5);
        car.setAc(true);
        car.setGps(true);
        car.setGearbox(Gearbox.MANUAL);
        car.setFuelType(FuelType.DIESEL);
        car.setVehicleCategory(VehicleCategory.HATCHBACK);
        car.isReserved(false);
        car.setRentPrice(new Price(20));

        car2.setMake("Ferrari");
        car2.setModel("Testarosa");
        car2.setSize(7);
        car2.setColor("color");
        car2.setSeats(5);
        car2.setDoors(5);
        car2.setAc(true);
        car2.setGps(true);
        car2.setGearbox(Gearbox.MANUAL);
        car2.setFuelType(FuelType.DIESEL);
        car2.setVehicleCategory(VehicleCategory.HATCHBACK);
        car2.isReserved(false);
        car2.setRentPrice(new Price(20));
    }

    @Test
    public void addAll() throws Exception {

    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void add() throws Exception {

        carService.add(car);

        assertEquals(3, carRepository.getCarsByMake("Trabant").size());
    }

    @Test
    public void addNotEquals() throws Exception {

        carService.add(car);

        assertNotEquals(0, carRepository.getCarsByMake("Trabant").size());
    }

    @Test
    public void delete() throws Exception {

        carService.delete(car);

        assertEquals(0, carRepository.getCarsByMake("Trabant").size());
    }

    @Test
    public void deleteNotEquals() throws Exception {

        carService.delete(car);

        assertNotEquals(1, carRepository.getCarsByMake("Trabant").size());
    }

    @Test
    public void update() throws Exception {
        carService.update(car2, car);

        assertEquals(1, carRepository.getCarsByMake("Ferrari").size());
    }

    @Test
    public void updateNotEquals() throws Exception {
        carService.update(car2, car);

        assertNotEquals(0, carRepository.getCarsByMake("Ferrari").size());
    }

    @Test
    public void findCarsByMake() throws Exception {
        assertEquals(47, carRepository.getCarsByMake("Bmw").size());

    }

    @Test
    public void findCarsByMakeNotEquals() throws Exception {
        assertNotEquals(0, carRepository.getCarsByMake("Bmw").size());

    }

    @Test
    public void findCarsByMakeAndModel() throws Exception {
        assertEquals(0, carRepository.getCarsByMakeAndModel("Bmw", "").size());
    }

    @Test
    public void findCarsByMakeAndModelNotEquals() throws Exception {
        assertNotEquals(1, carRepository.getCarsByMakeAndModel("Bmw", "").size());
    }

}