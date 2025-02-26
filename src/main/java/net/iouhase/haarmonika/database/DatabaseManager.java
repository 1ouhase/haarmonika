package net.iouhase.haarmonika.database;

import java.sql.*;

public class DatabaseManager {
    public static Connection connect() throws SQLException {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        connection = DriverManager.getConnection("jdbc:mysql://iouhase.net:3306/hår", "user", "26Uj96MSlPMV4o3aHqIypWcu");
        return connection;
    }
    public static void addBooking() {
        Connection connection = connect();
    }

    public static void cancelBooking() {
    }

    public static void editBooking() {
    }
}