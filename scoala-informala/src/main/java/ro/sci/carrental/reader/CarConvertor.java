package ro.sci.carrental.reader;

import ro.sci.carrental.domain.car.*;

public class CarConvertor implements Convertor<Car> {

    @Override
    public Car convert(String convertedString) throws InvalidEntityException {

        String[] tokens = convertedString.split(",");

        if (tokens.length != 13) {
            throw new InvalidEntityException("Invalid Car Description");
        }

        Car car = new Car();
        car.setMake(tokens[0]);
        car.setModel(tokens[1]);
        car.setSize(Float.valueOf(tokens[2]));
        car.setColor(tokens[3]);
        car.setSeats(Integer.valueOf(tokens[4]));
        car.setDoors(Integer.valueOf(tokens[5]));
        car.setAc(Boolean.getBoolean(tokens[6]));
        car.setGps(Boolean.getBoolean(tokens[7]));
        car.setGearbox(Gearbox.valueOf(tokens[8]));
        car.setFuelType(FuelType.valueOf(tokens[9].toUpperCase()));
        car.setVehicleCategory(VehicleCategory.valueOf(tokens[10].toUpperCase()));
        car.isReserved(Boolean.valueOf(tokens[11]));
        car.setRentPrice(new Price(Double.valueOf(tokens[12])));

        return car;
    }

}
