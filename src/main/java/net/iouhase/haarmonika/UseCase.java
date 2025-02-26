package net.iouhase.haarmonika;

import net.iouhase.haarmonika.model.LoginManager;

public class UseCase {
    public String checkUser(String username, String password) {
        LoginManager loginManager = new LoginManager();
        return loginManager.checkUser(username, password);
    }
}
