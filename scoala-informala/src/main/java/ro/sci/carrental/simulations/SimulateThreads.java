package ro.sci.carrental.simulations;

import ro.sci.carrental.dispatcher.CarRentalDispatcher;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.service.CarService;

public class SimulateThreads {

    public void simulate(CarService<Car> carService) throws InterruptedException {
        CarRentalDispatcher carRentalDispatcher = new CarRentalDispatcher();
        Thread rentCar1 = new Thread(new Runnable() {
            @Override
            public void run() {
                carRentalDispatcher.rent(carService.findCarsByMake("VW").get(0));
            }
        });

        Thread rentCar2 = new Thread(new Runnable() {
            @Override
            public void run() {
                carRentalDispatcher.rent(carService.findCarsByMake("Mercedes").get(0));
            }
        });

        Thread rentCar3 = new Thread(new Runnable() {
            @Override
            public void run() {
                carRentalDispatcher.rent(carService.findCarsByMake("Bmw").get(0));
            }
        });

        Thread rentCar4 = new Thread(new Runnable() {
            @Override
            public void run() {
                carRentalDispatcher.rent(carService.findCarsByMake("Citroen").get(0));
            }
        });

        Thread rentCar5 = new Thread(new Runnable() {
            @Override
            public void run() {
                carRentalDispatcher.rent(carService.findCarsByMake("Fiat").get(0));
            }
        });

        Thread freeupCar1 = new Thread(new Runnable() {
            @Override
            public void run() {
                carRentalDispatcher.returnCar(carService.findCarsByMake("VW").get(0));
            }
        });

        rentCar1.start();
        rentCar2.start();
        rentCar3.start();
        rentCar4.start();
        rentCar5.start();
        freeupCar1.start();

        rentCar1.join();
        rentCar2.join();
        rentCar3.join();
        rentCar4.join();
        rentCar5.join();
        freeupCar1.join();
    }
}
