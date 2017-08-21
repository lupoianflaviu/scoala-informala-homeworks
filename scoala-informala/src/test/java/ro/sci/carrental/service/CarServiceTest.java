package ro.sci.carrental.service;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.repository.CarRepositoryImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarServiceTest {

    Car car = new Car();
    private CarService<Car> carService = new CarServiceImpl();
    private CarRepository<Car> carRepositoryMock;
    private List<Car> carList = new ArrayList<>();

    @Before
    public void init() throws Exception {
        carRepositoryMock = mock(CarRepositoryImpl.class);
        carService.setCarRepository(carRepositoryMock);
        //        car.setId(380);
        //        car.setModel("Test");
        //        car.setMake("Test");
        //        car.setVehicleCategory(VehicleCategory.HATCHBACK);
        //        car.isReserved(false);
        //        car.setSize(3);
        //        car.setGps(false);
        //        car.setGearbox(Gearbox.MANUAL);
        //        car.setDoors(4);
        //        car.setSeats(5);
        //        car.setAc(false);
        //        car.setColor("red");
        //        car.setFuelType(FuelType.DIESEL);
        //        car.setRentPrice(new Price(20));
        carList.add(car);
        when(carRepositoryMock.getAll()).thenReturn(carList);
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(1, carService.getAll()
                                  .size());
        verify(carRepositoryMock, times(1)).getAll();
    }

    @Test
    public void testGetAllNotEquals() throws Exception {
        assertNotEquals(0, carService.getAll()
                                     .size());
    }

    @Test
    public void testAdd() throws Exception {
        Car car2 = new Car();
        carService.add(car2);

        verify(carRepositoryMock, times(1)).add(car2);
    }

    @Test
    public void testAddNotEquals() throws Exception {
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void deleteNotEquals() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void updateNotEquals() throws Exception {

    }

    @Test
    public void findCarsByMake() throws Exception {

    }

    @Test
    public void findCarsByMakeNotEquals() throws Exception {

    }

    @Test
    public void findCarsByMakeAndModel() throws Exception {
    }

    @Test
    public void findCarsByMakeAndModelNotEquals() throws Exception {
    }

}