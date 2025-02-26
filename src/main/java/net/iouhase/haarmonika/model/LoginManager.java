package net.iouhase.haarmonika.model;

import net.iouhase.haarmonika.database.DatabaseManager;

public class LoginManager {
    public boolean checkUser(String username, String password) {
        DatabaseManager databaseManager = new DatabaseManager();
        System.out.println("Checking user " + username + " with password " + password);
        User user = databaseManager.checkUser(username, password);
        if (user != null) {
            return (true);
        }
        else {
            return (false);
        }
    }
}
