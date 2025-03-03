package net.iouhase.haarmonika.model;

public class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;
    private String email;
    private String type;

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public User(String username, String password, String email, String type) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;

    }
}
