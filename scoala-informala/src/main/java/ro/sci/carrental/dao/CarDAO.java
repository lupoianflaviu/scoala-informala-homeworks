package ro.sci.carrental.dao;

import ro.sci.carrental.domain.car.*;
import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.service.CarService;
import ro.sci.carrental.service.CarServiceImpl;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarDAO {
    private static final Logger LOGGER = Logger.getLogger("RentingSimulation");
    Car car = new Car();
    CarRepository<Car> carRepository = new CarRepositoryImpl();
    CarService<Car> carService = new CarServiceImpl(carRepository);

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }

    }

    private static Connection newConnection(String type, String host, String port, String dbName, String user,
                                            String pw) {

        loadDriver();
        DriverManager.setLoginTimeout(60);

        try {
            String url = new StringBuilder().append("jdbc:").append(type)
                    .append("://")
                    .append(host)
                    .append(":")
                    .append(port)
                    .append("/")
                    .append(dbName)
                    .append("?user=")
                    .append(user)
                    .append("&password=")
                    .append(pw)
                    .toString();
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }

        return null;
    }

    public void printSql() {

        try (Connection conn = newConnection("postgresql",
                "localhost", "5432", "carrental",
                "admin2", "admin2");
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("select * from cars")) {

            while (rs.next()) {

                LOGGER.log(Level.INFO, rs.getInt("id") + "," +
                        rs.getString("make") + "," +
                        rs.getString("model") + "," +
                        rs.getFloat("dimension") + "," +
                        rs.getString("color") + "," +
                        rs.getInt("seats") + "," +
                        rs.getInt("doors") + "," +
                        rs.getBoolean("ac") + "," +
                        rs.getBoolean("gps") + "," +
                        rs.getString("gearbox") + "," +
                        rs.getString("fueltype") + "," +
                        rs.getString("vehiclecategory") + "," +
                        rs.getBoolean("reserved") + "," +
                        rs.getDouble("rentprice"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void read() {

        try (Connection conn = newConnection("postgresql",
                "localhost", "5432", "carrental",
                "admin2", "admin2");
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(
                     "select make,model,dimension,color,seats,doors,ac,gps," +
                             "gearbox,fueltype,vehiclecategory,reserved,rentprice from cars")) {

            while (rs.next()) {
                car = new Car();
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

                carService.add(car);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

//        return car;
    }

    public void printRepository() {
        LOGGER.log(Level.INFO, "\n\nLista masinilor din CarRepositoryImpl este: {0}\n", carRepository.getAll());
    }

    public void writeToSql() {


        try (Connection conn = newConnection("postgresql", "localhost", "5432",
                "carrental", "admin2", "admin2");
             PreparedStatement stm =
                     conn.prepareStatement("INSERT INTO outcars(make,model,dimension,color,seats,doors," +
                             "ac,gps,gearbox,fueltype,vehiclecategory,reserved,rentprice) " +
                             "values(?,?,?,?,?,?,?,?,?,?,?,?,?)")) {

            for (Car car : carRepository.getAll()) {

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

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        LOGGER.log(Level.INFO, "SCRIEREA IN TABELUL OUTCARS S-A INCHEIAT.");
    }
}
