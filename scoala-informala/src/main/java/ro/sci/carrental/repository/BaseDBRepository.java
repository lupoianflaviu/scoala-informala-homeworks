package ro.sci.carrental.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class BaseDBRepository {

    Connection newConnection() {
        loadDriver();
        DriverManager.setLoginTimeout(60);

        try {
            String url = new StringBuilder().append("jdbc:")
                                            .append("postgresql")
                                            .append("://")
                                            .append("localhost")
                                            .append(":")
                                            .append("5432")
                                            .append("/")
                                            .append("carrental")
                                            .append("?user=")
                                            .append("admin2")
                                            .append("&password=")
                                            .append("admin2")
                                            .toString();
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }

        return null;
    }

    private void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver")
                 .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }
    }
}
