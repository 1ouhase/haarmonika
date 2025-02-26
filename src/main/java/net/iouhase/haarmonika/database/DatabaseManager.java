package net.iouhase.haarmonika.database;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

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
    public static void addBooking() throws SQLException {
        Connection connection = connect();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into booking (idBooking, Dato, Tidspunkt, Navn, Aflysning) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, 1);
            statement.setDate(2, Date.valueOf(LocalDate.now()));
            statement.setTime(3, Time.valueOf(LocalTime.now()));
            statement.setString(4, "Niklas");
            statement.setBoolean(5, false);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void cancelBooking() throws SQLException {
        Connection connection = connect();
        try{
            PreparedStatement statement = connection.prepareStatement("update booking set Aflysning = true");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editBooking() throws SQLException {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update booking set Dato = ?, Tidspunkt = ?, Navn = ?, Aflysning = ? where idBooking = ?");
        }
    }
}