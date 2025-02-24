package net.iouhase.haarmonika.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    public static Connection Connect() throws SQLException {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        connection = DriverManager.getConnection("jdbc:mysql://iouhase.net:3306", "user", "26Uj96MSlPMV4o3aHqIypWcu");
        return connection;
    }
}
