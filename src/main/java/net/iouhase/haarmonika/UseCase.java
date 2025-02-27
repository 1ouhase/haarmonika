package net.iouhase.haarmonika;

import net.iouhase.haarmonika.database.DatabaseManager;
import net.iouhase.haarmonika.model.LoginManager;
import net.iouhase.haarmonika.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UseCase {
    public boolean checkUser(String username, String password) {
        LoginManager loginManager = new LoginManager();
        return loginManager.checkUser(username, password);
    }

    public List<String> getUsers() {
        List<String> users = DatabaseManager.getUsers();
        return users;
    }
//    public List<User> getUsers() {
//        Map<Integer, String> usersMap = DatabaseManager.getUsers();
//        List<User> users = new ArrayList<>();
//        for (Map.Entry<Integer, String> entry : usersMap.entrySet()) {
//            int userId = entry.getKey();
//            String username = entry.getValue();
//            User user = new User(userId, username);
//            users.add(user);
//        }
//        return users;
//    }
    public String addUser(String username, String password) {
        return DatabaseManager.addUser(username, password);
    }
    public String removeUser(String username) {
        return DatabaseManager.removeUser(username);
    }
    public String updateUser(String username, String password) {
        return DatabaseManager.updateUser(username, password);
    }
}
