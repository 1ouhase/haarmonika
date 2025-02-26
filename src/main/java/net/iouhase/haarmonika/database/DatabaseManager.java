package net.iouhase.haarmonika.database;

import net.iouhase.haarmonika.model.User;

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
    private User user;

    public User checkUser(String username, String pass) {
        String sql = "SELECT * FROM logintest.user WHERE username=? AND password=?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("checking database");
            if (resultSet.next()) {
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                user = new User(userName, password);
                System.out.println(userName + ": OK");
                return user;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}