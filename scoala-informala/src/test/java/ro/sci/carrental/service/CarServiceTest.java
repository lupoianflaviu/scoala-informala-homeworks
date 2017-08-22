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
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author flaviu.lupoian
 *
 * date 2017.08.22
 */
public class CarServiceTest {

    private Car car = new Car();
    private Car car2 = new Car();
    private CarService<Car> carService = new CarServiceImpl();
    private CarRepository<Car> carRepositoryMock;
    private List<Car> carList = new ArrayList<>();

    @Before
    public void init() throws Exception {
        car.setId(100);
        car2.setId(101);
        carRepositoryMock = mock(CarRepositoryImpl.class);
        carService.setCarRepository(carRepositoryMock);
        carList.add(car);
        when(carRepositoryMock.getAll()).thenReturn(carList);
        when(carRepositoryMock.getCarsByMake(anyString())).thenReturn(carList);
        when(carRepositoryMock.getCarsByMakeAndModel(anyString(), anyString())).thenReturn(carList);
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
        carService.add(car2);

        verify(carRepositoryMock, times(1)).add(car2);
        assertEquals(1, carService.getAll()
                                  .size());
    }

    @Test
    public void testAddNotUsed() throws Exception {
        verify(carRepositoryMock, never()).add(car2);
    }

    @Test
    public void testDelete() throws Exception {
        carService.add(car2);
        carService.delete(car);
        carService.delete(car2);

        verify(carRepositoryMock, times(2)).delete(car);
    }

    @Test
    public void testDeleteNotUsed() throws Exception {
        carService.add(car2);
        verify(carRepositoryMock, never()).delete(car);
    }

    @Test
    public void testUpdate() throws Exception {
        carService.update(car2);
        verify(carRepositoryMock, times(1)).update(car2);
    }

    @Test
    public void testUpdateNotUsed() throws Exception {
        verify(carRepositoryMock, never()).update(car2);
    }

    @Test
    public void testFindCarsByMake() throws Exception {
        carService.findCarsByMake("Bmw");

        verify(carRepositoryMock, times(1)).getCarsByMake("Bmw");
        assertEquals(1, carService.getAll()
                                  .size());
    }

    @Test
    public void testFindCarsByMakeNotEquals() throws Exception {
        carService.findCarsByMake("Mercedes");
        verify(carRepositoryMock, never()).getCarsByMake("Bmw");
        assertNotEquals(0, carService.getAll()
                                     .size());
    }

    @Test
    public void testFindCarsByMakeAndModel() throws Exception {
        carService.findCarsByMakeAndModel("Bmw", "520d");

        verify(carRepositoryMock, times(1)).getCarsByMakeAndModel("Bmw", "520d");
        assertEquals(1, carService.getAll()
                                  .size());
    }

    @Test
    public void testFindCarsByMakeAndModelNotEquals() throws Exception {
        carService.findCarsByMakeAndModel("Mercedes", "e200");

        verify(carRepositoryMock, never()).getCarsByMakeAndModel("Bmw", "520d");
        assertNotEquals(0, carService.getAll()
                                     .size());
    }
}