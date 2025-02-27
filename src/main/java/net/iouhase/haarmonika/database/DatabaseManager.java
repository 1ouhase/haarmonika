package net.iouhase.haarmonika.database;

import net.iouhase.haarmonika.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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


    public static List<String> getUsers() {
        String sql = "select * from users";
        List<String> usernames = new ArrayList<>();
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                usernames.add(name);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usernames;
    }
        //    public static Map<Integer, String> getUsers() {
//        String sql = "select * from users";
//        Map<Integer, String> users = new HashMap<Integer, String>();
//        try (Connection connection = connect();
//        Statement statement = connect().createStatement();
//        ResultSet resultSet = statement.executeQuery(sql)){
//            while (resultSet.next()) {
//                users.put(resultSet.getInt(1), resultSet.getString(2));
//            }
//        }catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public static String addUser(String userName, String password) {
        String sql = "insert into users (name, password) values (?, ?)";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                return (userName + " added");
            }
            else {
                return (userName + " not added");
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return (userName + " not added");
        }
    }

    public static Boolean checkUser(String username, String pass) {
        Boolean ok;
        String sql = "SELECT * FROM logintest.user WHERE username=? AND password=?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("checking database");
            if (resultSet.next()) {
//                String userName = resultSet.getString("username");
//                String password = resultSet.getString("password");
//                user = new User(userName, password);
//                System.out.println(userName + ": OK");
                ok = true;
                return ok;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static String removeUser(String username) {
        String sql = "DELETE FROM users WHERE username=?";
        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, username);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                return (username + " deleted");
            }
            else {
                return (username + " not deleted");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return "Bruger slettet";
    }
    public static String updateUser(String username, String password) {
        String sql = "update users set name=?, password=? where username=?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return (username + " updated");
            }
            else {
                return (username + " not updated");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
