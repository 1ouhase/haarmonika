package net.iouhase.haarmonika.model;

public class LoginManager {
    public String checkUser(String username, String password) {
        DatabaseHandler databaseHandler = new databaseHandler();
        System.out.println("Checking user " + username + " with password " + password);
        User user = databaseHandler.checkUser(username, password);
        if (user != null) {
            return "OK";
        }
        else {
            return "User not found";
        }
    }
}
