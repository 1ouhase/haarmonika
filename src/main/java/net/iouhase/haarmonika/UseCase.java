package net.iouhase.haarmonika;

import net.iouhase.haarmonika.database.DatabaseManager;
import net.iouhase.haarmonika.model.Booking;
import net.iouhase.haarmonika.model.Email;
import net.iouhase.haarmonika.model.User;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

public class UseCase {
    NotificationService notificationService = new NotificationService();

    public boolean checkUser(String username, String password) {
//        UserRepository loginManager = new UserRepository();
//        return loginManager.checkUser(username, password);
        return DatabaseManager.checkUser(username, password);
    }

    public List<String> getUsers() {
        List<String> users = DatabaseManager.getUsers();
        return users;
    }

    public String addUser(String username, String password, String email, String type) {
        User user = new User(username, password, email, type);
        return DatabaseManager.addUser(user);
    }
    public String removeUser(String username) {
        return DatabaseManager.removeUser(username);
    }
    public String updateUser(String username, String password, String oldName, String email, String type) {
        return DatabaseManager.updateUser(username, password, oldName, email, type);
    }
    public String notifyOfBooking(String email) {//Sender når man trykker i adminView
        return "Husk din tid hos HårMonika, " + notificationService.notifyOfBooking(email);
    }
    public void autoNotify() {
//        SchedulerService schedulerService = new SchedulerService();
//        schedulerService.sendEmails();
        notificationService.autoNotify();
    }
    public void sendEmails(){
        SchedulerService scheduler = new SchedulerService();
        scheduler.sendEmails();
    }

    public ArrayList<Booking> getBookings()throws SQLException {
        return DatabaseManager.getBookings();
    }
}

