package ro.sci.carrental.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class BaseDBRepository {

    void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }
    }

    Connection newConnection(String type, String host, String port, String dbName, String user,
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
}
