package ro.sci.carrental;

import ro.sci.carrental.domain.car.*;
import ro.sci.carrental.reader.InvalidEntityException;
import ro.sci.carrental.repository.DBCarRepositoryImpl;
import ro.sci.carrental.service.CarService;
import ro.sci.carrental.service.CarServiceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>RentACar Model</h1>
 * RentACar simulates a car rental business.
 * <p>
 * <h>
 * This is the main method which makes use of SimulateCars and SimulateCustomer classes to do search queries.
 *
 * @author Flaviu Lupoian
 * @version 1.2
 * @since 1.8
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    public static void main(String[] args) throws InvalidEntityException, InterruptedException {

        CarService<Car> carService = new CarServiceImpl(new DBCarRepositoryImpl());
        carService.addAll();
        LOGGER.log(Level.INFO, "\nLista masinilor din Repository este: " + carService.getAll().toString());

        for (Car car : carService.getAll()) {
            carService.add(car);
        }

        Car seat = new Car();
        seat.setMake("Seat");
        seat.setModel("Leon");
        seat.setColor("black");
        seat.setAc(true);
        seat.setRentPrice(new Price(26.5));
        seat.setSeats(4);
        seat.setDoors(4);
        seat.setGearbox(Gearbox.MANUAL);
        seat.setFuelType(FuelType.DIESEL);
        seat.setVehicleCategory(VehicleCategory.HATCHBACK);
        seat.setGps(false);
        seat.setSize(4.5f);
        seat.isReserved(false);
        carService.add(seat);

        Car testCar = new Car();
        testCar.setMake("TestCar");
        testCar.setModel("TestModel");
        testCar.setColor("black");
        testCar.setAc(true);
        testCar.setRentPrice(new Price(26.5));
        testCar.setSeats(4);
        testCar.setDoors(4);
        testCar.setFuelType(FuelType.DIESEL);
        testCar.setGearbox(Gearbox.MANUAL);
        testCar.setVehicleCategory(VehicleCategory.HATCHBACK);
        testCar.setGps(false);
        testCar.setSize(4.5f);
        testCar.isReserved(false);

        carService.update(testCar, seat);

        //cerinte anterioare

//        CarDAO carDAO = new CarDAO();
//        carDAO.read();
//        carDAO.printRepository();

//        File carsFile = new File("cars.txt");
//        EntityReader entityReader = new EntityReader();
//        List<String> carLines = entityReader.readLines(carsFile);
//        Convertor<Car> carConvertor = new CarConvertor();


//        for (String line : carLines) {
//            carService.add(carConvertor.convert(line));
//        }
////        trebuie sa facem new la implementare in interfata neaparat

//

//
//        File customerFile = new File("customers.txt");
//        List<String> customerLines = entityReader.readLines(customerFile);
//        Convertor<Customer> customerConvertor = new CustomerConvertor();
//        CustomerService<Customer> customerService = new CustomerServiceImpl(new CustomerRepositoryImpl);
//
//        for (String line : customerLines) {
//            customerService.add(customerConvertor.convert(line));
//        }
////
//        //efectuam cautari masini
//        SimulateCars<Car> simulateCars = new SimulateCars<>();
//        simulateCars.searches(new CarRepositoryImpl());
////
//        //efectuam cautari clienti
//        SimulateCustomer simulateCustomer = new SimulateCustomer();
//        simulateCustomer.searches(new CustomerRepositoryImpl());
//
//        File outCars = new File("outcars.txt");
//        CarWriter carWriter = new CarWriter();
//        carWriter.writeObjects(carService.getAll(), outCars);
//
//        File outCustomers = new File("outcustomers.txt");
//        CustomerWriter customerWriter = new CustomerWriter();
//        customerWriter.writeObjects(customerRepository.getAll(), outCustomers);
//
////        Threads for renting and returning cars
//        SimulateThreads simulateThreads = new SimulateThreads();
//        simulateThreads.simulate(carService);
    }
}
