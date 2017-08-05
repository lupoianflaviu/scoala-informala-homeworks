package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBCarRepositoryImpl extends BaseDBRepository implements Repository<Car> {

    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");
    private List<Car> cars = new ArrayList<>();

    @Override
    void loadDriver() {

        super.loadDriver();
    }

    @Override
    Connection newConnection(String type, String host, String port, String dbName, String user, String pw) {

        return super.newConnection(type, host, port, dbName, user, pw);
    }

    @Override
    public void addAll() {
        try (Connection conn = newConnection("postgresql",
                "localhost", "5432", "carrental",
                "admin2", "admin2");
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(
                     "select make,model,dimension,color,seats,doors,ac,gps," +
                             "gearbox,fueltype,vehiclecategory,reserved,rentprice from cars")) {

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
            ex.printStackTrace();
        }
    }

    @Override
    public void add(Car car) {
        try (Connection conn = newConnection("postgresql", "localhost", "5432",
                "carrental", "admin2", "admin2");
             PreparedStatement stm =
                     conn.prepareStatement("INSERT INTO outcars(make,model,dimension,color,seats,doors," +
                             "ac,gps,gearbox,fueltype,vehiclecategory,reserved,rentprice) " +
                             "values(?,?,?,?,?,?,?,?,?,?,?,?,?)")) {

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

            conn.commit();
            conn.setAutoCommit(true);
            stm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        LOGGER.log(Level.INFO, "SCRIEREA IN TABELUL OUTCARS S-A INCHEIAT.");
    }

    @Override
    public void delete(Car car) {
        //delete by model
        try (Connection conn = newConnection("postgresql", "localhost", "5432",
                "carrental", "admin2", "admin2");
             PreparedStatement stm =
                     conn.prepareStatement("DELETE FROM outcars where model=?")) {

            stm.setString(1, car.getModel());
            stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        LOGGER.log(Level.INFO, "STERGEREA MASINII DIN TABELUL OUTCARS S-A INCHEIAT.");
    }

    @Override
    public void update(Car car, Car oldCar) {
        try (Connection conn = newConnection("postgresql", "localhost", "5432",
                "carrental", "admin2", "admin2");
             PreparedStatement stm =
                     conn.prepareStatement("UPDATE outcars " +
                             "SET make=?, model=?, dimension=?, color=?, seats=?, doors=?, ac=?, gps=?, gearbox=?, fueltype=?, vehiclecategory=? ,reserved=?, rentprice=? " +
                             "WHERE model = ?")) {

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
            ex.printStackTrace();
        }

        LOGGER.log(Level.INFO, "Modificarea masinii s-a terminat");
    }

    @Override
    public List<Car> getAll() {

        return cars;
    }
}
