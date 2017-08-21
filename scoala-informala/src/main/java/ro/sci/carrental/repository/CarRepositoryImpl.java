package ro.sci.carrental.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.FuelType;
import ro.sci.carrental.domain.car.Gearbox;
import ro.sci.carrental.domain.car.Price;
import ro.sci.carrental.domain.car.VehicleCategory;

public class CarRepositoryImpl extends BaseDBRepository implements CarRepository<Car> {

    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");

    private static final String SQL_SELECT_FROM_CARS =
            "select make,model,dimension,color,seats,doors,ac,gps," + "gearbox,fueltype,vehiclecategory,reserved,rentprice from cars";

    private static final String SQL_INSERT_INTO_OUTCARS =
            "INSERT INTO outcars(make,model,dimension,color,seats,doors," + "ac,gps,gearbox,fueltype,vehiclecategory,reserved,rentprice) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String DELETE_FROM_OUTCARS_WHERE_MODEL = "DELETE FROM outcars where model=?";

    private static final String SQL_UPDATE_OUTCARS =
            "UPDATE outcars " + "SET make=?, model=?, dimension=?, color=?, seats=?, doors=?, ac=?, gps=?, gearbox=?, fueltype=?, "
                    + "vehiclecategory=? ,reserved=?, rentprice=? " + "WHERE model = ?";
    private static final String MAKE = "make";
    private static final String MODEL = "model";
    private static final String DIMENSION = "dimension";
    private static final String COLOR = "color";
    private static final String SEATS = "seats";
    private static final String DOORS = "doors";
    private static final String AC = "ac";
    private static final String GPS = "gps";
    private static final String GEARBOX = "gearbox";
    private static final String FUELTYPE = "fueltype";
    private static final String VEHICLECATEGORY = "vehiclecategory";
    private static final String RESERVED = "reserved";
    private static final String RENTPRICE = "rentprice";
    private static final String DATABASE_ERROR = "Database error!";
    private static final String EXCEPTION_THROWN = "Exception thrown";
    private static final String WRITING_IN_OUTCARS_HAS_FINISHED = "WRITING IN OUTCARS HAS FINISHED.";
    private static final String CAR_DELETE_HAS_COMPLETED = "CAR DELETE HAS COMPLETED.";
    private static final String CAR_UPDATE_HAS_COMPLETED = "CAR UPDATE HAS COMPLETED.";
    private static final String SELECT_FROM_OUTCARS = "select * from outcars";
    private static final String SELECT_FROM_OUTCARS_WHERE_MAKE = "select * from outcars where make=?";
    private static final String SELECT_FROM_OUTCARS_WHERE_MAKE_AND_MODEL = "select * from outcars where make=? AND model=?";
    private static final String TO_BE_IMPLEMENTED = "to be implemented";

    @Override
    public void add(Car car) {
        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(SQL_INSERT_INTO_OUTCARS)) {

            conn.setAutoCommit(false);
            stm.setString(1, car.getMake());
            stm.setString(2, car.getModel());
            stm.setFloat(3, car.getSize());
            stm.setString(4, car.getColor());
            stm.setInt(5, car.getSeats());
            stm.setInt(6, car.getDoors());
            stm.setBoolean(7, car.hasAc());
            stm.setBoolean(8, car.isGps());
            stm.setString(9, car.getGearbox()
                                .toString());
            stm.setString(10, car.getFuelType()
                                 .toString());
            stm.setString(11, car.getVehicleCategory()
                                 .toString());
            stm.setBoolean(12, car.getReserved());
            stm.setDouble(13, car.getRentPrice()
                                 .getValue());

            stm.execute();
            conn.commit();
            conn.setAutoCommit(true);

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        LOGGER.log(Level.INFO, WRITING_IN_OUTCARS_HAS_FINISHED);
    }

    @Override
    public void delete(Car car) {
        //delete by model
        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(DELETE_FROM_OUTCARS_WHERE_MODEL)) {

            stm.setString(1, car.getModel());
            stm.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        LOGGER.log(Level.INFO, CAR_DELETE_HAS_COMPLETED);
    }

    @Override
    public void update(Car car, Car oldCar) {
        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(SQL_UPDATE_OUTCARS)) {

            stm.setString(1, car.getMake());
            stm.setString(2, car.getModel());
            stm.setFloat(3, car.getSize());
            stm.setString(4, car.getColor());
            stm.setInt(5, car.getSeats());
            stm.setInt(6, car.getDoors());
            stm.setBoolean(7, car.hasAc());
            stm.setBoolean(8, car.isGps());
            stm.setString(9, car.getGearbox()
                                .toString());
            stm.setString(10, car.getFuelType()
                                 .toString());
            stm.setString(11, car.getVehicleCategory()
                                 .toString());
            stm.setBoolean(12, car.getReserved());
            stm.setDouble(13, car.getRentPrice()
                                 .getValue());

            stm.setString(14, oldCar.getModel());

            stm.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        LOGGER.log(Level.INFO, CAR_UPDATE_HAS_COMPLETED);
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();

        try (Connection conn = newConnection(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(SELECT_FROM_OUTCARS)) {

            while (rs.next()) {

                Car car = new Car();
                car.setMake(rs.getString(MAKE));
                car.setModel(rs.getString(MODEL));
                car.setSize(rs.getFloat(DIMENSION));
                car.setColor(rs.getString(COLOR));
                car.setSeats(rs.getInt(SEATS));
                car.setDoors(rs.getInt(DOORS));
                car.setAc(rs.getBoolean(AC));
                car.setGps(rs.getBoolean(GPS));
                car.setGearbox(Gearbox.valueOf(rs.getString(GEARBOX)));
                car.setFuelType(FuelType.valueOf(rs.getString(FUELTYPE)));
                car.setVehicleCategory(VehicleCategory.valueOf(rs.getString(VEHICLECATEGORY)));
                car.isReserved(rs.getBoolean(RESERVED));
                car.setRentPrice(new Price(rs.getDouble(RENTPRICE)));

                cars.add(car);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        return cars;
    }

    @Override
    public List<Car> getCarsByMake(String make) {

        List<Car> searchedCars = new ArrayList<>();

        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(SELECT_FROM_OUTCARS_WHERE_MAKE)) {

            stm.setString(1, make);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Car car = new Car();

                car.setMake(rs.getString(MAKE));
                car.setModel(rs.getString(MODEL));
                car.setSize(rs.getFloat(DIMENSION));
                car.setColor(rs.getString(COLOR));
                car.setSeats(rs.getInt(SEATS));
                car.setDoors(rs.getInt(DOORS));
                car.setAc(rs.getBoolean(AC));
                car.setGps(rs.getBoolean(GPS));
                car.setGearbox(Gearbox.valueOf(rs.getString(GEARBOX)));
                car.setFuelType(FuelType.valueOf(rs.getString(FUELTYPE)));
                car.setVehicleCategory(VehicleCategory.valueOf(rs.getString(VEHICLECATEGORY)));
                car.isReserved(rs.getBoolean(RESERVED));
                car.setRentPrice(new Price(rs.getDouble(RENTPRICE)));

                searchedCars.add(car);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        return searchedCars;
    }

    @Override
    public List<Car> getCarsByMakeAndModel(String make, String model) {

        List<Car> searchedCars = new ArrayList<>();

        try (Connection conn = newConnection(); PreparedStatement stm = conn.prepareStatement(SELECT_FROM_OUTCARS_WHERE_MAKE_AND_MODEL)) {

            stm.setString(1, make);
            stm.setString(2, model);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Car car = new Car();

                car.setMake(rs.getString(MAKE));
                car.setModel(rs.getString(MODEL));
                car.setSize(rs.getFloat(DIMENSION));
                car.setColor(rs.getString(COLOR));
                car.setSeats(rs.getInt(SEATS));
                car.setDoors(rs.getInt(DOORS));
                car.setAc(rs.getBoolean(AC));
                car.setGps(rs.getBoolean(GPS));
                car.setGearbox(Gearbox.valueOf(rs.getString(GEARBOX)));
                car.setFuelType(FuelType.valueOf(rs.getString(FUELTYPE)));
                car.setVehicleCategory(VehicleCategory.valueOf(rs.getString(VEHICLECATEGORY)));
                car.isReserved(rs.getBoolean(RESERVED));
                car.setRentPrice(new Price(rs.getDouble(RENTPRICE)));

                searchedCars.add(car);
            }


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }

        return searchedCars;
    }
}
