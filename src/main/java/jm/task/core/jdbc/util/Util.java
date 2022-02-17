package jm.task.core.jdbc.util;

import java.security.PublicKey;
import java.sql.*;

public class Util {
    private final String URL = "jdbc:mysql://localhost:3306/javadb";
    private final String USERNAME = "root";
    private final String PASSWORD = "1234";
    Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public Util() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
