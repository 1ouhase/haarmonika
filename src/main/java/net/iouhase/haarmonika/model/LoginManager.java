package net.iouhase.haarmonika.model;

import net.iouhase.haarmonika.database.DatabaseManager;

public class LoginManager {
    public boolean checkUser(String username, String password) {
        DatabaseManager databaseManager = new DatabaseManager();
        System.out.println("Checking user " + username + " with password " + password);
        return(databaseManager.checkUser(username, password));
    }
}
