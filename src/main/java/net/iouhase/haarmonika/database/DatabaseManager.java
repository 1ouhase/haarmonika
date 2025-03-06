package net.iouhase.haarmonika.database;

import net.iouhase.haarmonika.model.Booking;
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
    public static void addBooking(Booking booking) throws SQLException {
        Connection connection = connect();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into booking (idBooking, Dato, Tidspunkt, Navn, Aflysning) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, 1);
            statement.setDate(2, Date.valueOf(LocalDate.now()));
            statement.setTime(3, Time.valueOf(LocalTime.now()));
            statement.setString(4, "Monika");
            statement.setBoolean(5, false);
            statement.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void cancelBooking() throws SQLException {
        Connection connection = connect();
        try{
            PreparedStatement statement = connection.prepareStatement("update booking set Aflysning = true");
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editBooking() throws SQLException {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("update booking set Dato = ?, Tidspunkt = ?, Navn = ?, Aflysning = ? where idBooking = ?");
            statement.execute();
        }
    }


    public static List<String> getUsers() {
        String sql = "select * from Person";
        List<String> usernames = new ArrayList<>();
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
//                int id = resultSet.getInt("idPerson");
                String name = resultSet.getString("Navn");
                String email = resultSet.getString("Email");
                String type = resultSet.getString("Type");
                usernames.add(name + ", " + email + ", " + type);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usernames;
    }
        public static String addUser(User user) {
            String sql = "insert into Person (Navn, Password, Email, Type) values (?, ?, ?)";
            try (Connection connection = connect();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getType());
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    return (user.getUsername() + " added");
                }
                else {
                    return (user.getUsername() + " not added");
                }

            }catch (SQLException e) {
                System.out.println(e.getMessage());
                return (user.getUsername() + " not added");
            }
        }

    public static Boolean checkUser(String username, String pass) {
        Boolean ok;
        String sql = "SELECT * FROM Person WHERE Navn=? AND Password=?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("checking database");
            if (resultSet.next()) {
                ok = true;
                return ok;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static String removeUser(String username) {
        String sql = "DELETE FROM Person WHERE Navn=?";
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
    public static String updateUser(String username, String password, String oldName, String email, String type) {
        String sql = "update Person set Navn=?, Password=?, Email=?, Type=? where Navn=?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, oldName);
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

    public static String getTime(String email){
        String sql = "SELECT dato, tidspunkt FROM booking Join Person on booking.FKKunde = Person.idPerson where Email = ? limit 1";
        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String date = resultSet.getString("Dato");
                String time = resultSet.getString("Tidspunkt");
                return date + ", kl " + time;
            }
        }
        catch (SQLException e){
        }
        return null;
    }
    public static List<String> getTomorrowsAppointments(String fortnite){
        List<String> tomorrows = new ArrayList<>();
        String sql = "SELECT dato, tidspunkt, Email FROM booking Join Person on booking.FKKunde = Person.idPerson Where dato = ?";
        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, fortnite);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String date = resultSet.getString("Dato");
                String time = resultSet.getString("Tidspunkt");
                String email = resultSet.getString("Email");
                tomorrows.add(date + ", " + time + ", " + email);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return tomorrows;
    }
}
