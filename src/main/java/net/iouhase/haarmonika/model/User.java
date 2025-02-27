package net.iouhase.haarmonika.model;

public class User {
    private String username;
    private String password;
    private int id;
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
