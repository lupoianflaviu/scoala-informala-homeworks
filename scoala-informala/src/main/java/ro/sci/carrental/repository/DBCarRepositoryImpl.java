package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBCarRepositoryImpl extends BaseDBRepository implements CarRepository<Car> {

    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    private static final String SQL_SELECT_FROM_CARS = "select make,model,dimension,color,seats,doors,ac,gps," +
            "gearbox,fueltype,vehiclecategory,reserved,rentprice from cars";

    private static final String SQL_INSERT_INTO_OUTCARS = "INSERT INTO outcars(make,model,dimension,color,seats,doors," +
            "ac,gps,gearbox,fueltype,vehiclecategory,reserved,rentprice) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String DELETE_FROM_OUTCARS_WHERE_MODEL = "DELETE FROM outcars where model=?";

    private static final String SQL_UPDATE_OUTCARS = "UPDATE outcars " +
            "SET make=?, model=?, dimension=?, color=?, seats=?, doors=?, ac=?, gps=?, gearbox=?, fueltype=?, " +
            "vehiclecategory=? ,reserved=?, rentprice=? " +
            "WHERE model = ?";

    @Override
    public void addAll() {
        try (Connection conn = newConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(
                     SQL_SELECT_FROM_CARS)) {

            while (rs.next()) {
                Car car = new Car();
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setSize(rs.getFloat("dimension"));
                car.setColor(rs.getString("color"));
                car.setSeats(rs.getInt("seats"));
                car.setDoors(rs.getInt("doors"));
                car.setAc(rs.getBoolean("ac"));
                car.setGps(rs.getBoolean("gps"));
                car.setGearbox(Gearbox.valueOf(rs.getString("gearbox")));
                car.setFuelType(FuelType.valueOf(rs.getString("fueltype")));
                car.setVehicleCategory(VehicleCategory.valueOf(rs.getString("vehiclecategory")));
                car.isReserved(rs.getBoolean("reserved"));
                car.setRentPrice(new Price(rs.getDouble("rentprice")));

                add(car);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }
    }

    @Override
    public void add(Car car) {
        try (Connection conn = newConnection();
             PreparedStatement stm =
                     conn.prepareStatement(SQL_INSERT_INTO_OUTCARS)) {

            conn.setAutoCommit(false);
            stm.setString(1, car.getMake());
            stm.setString(2, car.getModel());
            stm.setFloat(3, car.getSize());
            stm.setString(4, car.getColor());
            stm.setInt(5, car.getSeats());
            stm.setInt(6, car.getDoors());
            stm.setBoolean(7, car.hasAc());
            stm.setBoolean(8, car.isGps());
            stm.setString(9, car.getGearbox().toString());
            stm.setString(10, car.getFuelType().toString());
            stm.setString(11, car.getVehicleCategory().toString());
            stm.setBoolean(12, car.getReserved());
            stm.setDouble(13, car.getRentPrice().getValue());

            stm.execute();
            conn.commit();
            conn.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        LOGGER.log(Level.INFO, "SCRIEREA IN TABELUL OUTCARS S-A INCHEIAT.");
    }

    @Override
    public void delete(Car car) {
        //delete by model
        try (Connection conn = newConnection();
             PreparedStatement stm =
                     conn.prepareStatement(DELETE_FROM_OUTCARS_WHERE_MODEL)) {

            stm.setString(1, car.getModel());
            stm.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        LOGGER.log(Level.INFO, "STERGEREA MASINII DIN TABELUL OUTCARS S-A INCHEIAT.");
    }

    @Override
    public void update(Car car, Car oldCar) {
        try (Connection conn = newConnection();
             PreparedStatement stm =
                     conn.prepareStatement(SQL_UPDATE_OUTCARS)) {

            stm.setString(1, car.getMake());
            stm.setString(2, car.getModel());
            stm.setFloat(3, car.getSize());
            stm.setString(4, car.getColor());
            stm.setInt(5, car.getSeats());
            stm.setInt(6, car.getDoors());
            stm.setBoolean(7, car.hasAc());
            stm.setBoolean(8, car.isGps());
            stm.setString(9, car.getGearbox().toString());
            stm.setString(10, car.getFuelType().toString());
            stm.setString(11, car.getVehicleCategory().toString());
            stm.setBoolean(12, car.getReserved());
            stm.setDouble(13, car.getRentPrice().getValue());

            stm.setString(14, oldCar.getModel());

            stm.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        LOGGER.log(Level.INFO, "Modificarea masinii s-a terminat");
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();

        try (Connection conn = newConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(
                     "select * from outcars")) {

            while (rs.next()) {

                Car car = new Car();
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setSize(rs.getFloat("dimension"));
                car.setColor(rs.getString("color"));
                car.setSeats(rs.getInt("seats"));
                car.setDoors(rs.getInt("doors"));
                car.setAc(rs.getBoolean("ac"));
                car.setGps(rs.getBoolean("gps"));
                car.setGearbox(Gearbox.valueOf(rs.getString("gearbox")));
                car.setFuelType(FuelType.valueOf(rs.getString("fueltype")));
                car.setVehicleCategory(VehicleCategory.valueOf(rs.getString("vehiclecategory")));
                car.isReserved(rs.getBoolean("reserved"));
                car.setRentPrice(new Price(rs.getDouble("rentprice")));

                cars.add(car);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        return cars;
    }

    @Override
    public List<Car> getCarsByMake(String make) {

        List<Car> searchedCars = new ArrayList<>();

        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement("select * from outcars where make=?")) {

            stm.setString(1, make);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Car car = new Car();

                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setSize(rs.getFloat("dimension"));
                car.setColor(rs.getString("color"));
                car.setSeats(rs.getInt("seats"));
                car.setDoors(rs.getInt("doors"));
                car.setAc(rs.getBoolean("ac"));
                car.setGps(rs.getBoolean("gps"));
                car.setGearbox(Gearbox.valueOf(rs.getString("gearbox")));
                car.setFuelType(FuelType.valueOf(rs.getString("fueltype")));
                car.setVehicleCategory(VehicleCategory.valueOf(rs.getString("vehiclecategory")));
                car.isReserved(rs.getBoolean("reserved"));
                car.setRentPrice(new Price(rs.getDouble("rentprice")));

                searchedCars.add(car);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        return searchedCars;
    }

    @Override
    public List<Car> getCarsByMakeAndModel(String make, String model) {

        List<Car> searchedCars = new ArrayList<>();

        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement("select * from outcars where make=? AND model=?")) {

            stm.setString(1, make);
            stm.setString(2, model);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Car car = new Car();

                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setSize(rs.getFloat("dimension"));
                car.setColor(rs.getString("color"));
                car.setSeats(rs.getInt("seats"));
                car.setDoors(rs.getInt("doors"));
                car.setAc(rs.getBoolean("ac"));
                car.setGps(rs.getBoolean("gps"));
                car.setGearbox(Gearbox.valueOf(rs.getString("gearbox")));
                car.setFuelType(FuelType.valueOf(rs.getString("fueltype")));
                car.setVehicleCategory(VehicleCategory.valueOf(rs.getString("vehiclecategory")));
                car.isReserved(rs.getBoolean("reserved"));
                car.setRentPrice(new Price(rs.getDouble("rentprice")));

                searchedCars.add(car);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Database error!");
            throw new RuntimeException("Exception thrown");
        }

        return searchedCars;
    }

    @Override
    public void reserve(Car car) {
        LOGGER.log(Level.WARNING, "to be implemented");
    }

    @Override
    public void freeup(Car car) {
        LOGGER.log(Level.WARNING, "to be implemented");
    }

    @Override
    public int getCapacity() {
        LOGGER.log(Level.WARNING, "to be implemented");
        return 0;
    }
}
