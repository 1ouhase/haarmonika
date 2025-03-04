package net.iouhase.haarmonika;

import net.iouhase.haarmonika.database.DatabaseManager;
import net.iouhase.haarmonika.model.LoginManager;
import net.iouhase.haarmonika.model.User;

import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

public class UseCase {
    public boolean checkUser(String username, String password) {
        LoginManager loginManager = new LoginManager();
        return loginManager.checkUser(username, password);
    }

    public List<String> getUsers() {
        List<String> users = DatabaseManager.getUsers();
        return users;
    }

    public String addUser(String username, String password, String email) {
        User user = new User(username, password, email);
        return DatabaseManager.addUser(user);
    }
    public String removeUser(String username) {
        return DatabaseManager.removeUser(username);
    }
    public String updateUser(String username, String password, String oldName, String email) {
        return DatabaseManager.updateUser(username, password, oldName, email);
    }
    public String notifyOfBooking(String email) {//Sender når man trykker i adminView
        System.out.println("Husk din tid hos HårMonika, " + email + " " + DatabaseManager.getTime(email));
        return "Husk din tid hos HårMonika, " + DatabaseManager.getTime(email);
    }
    public void autoNotify() {
        List<String> tomorrows = getTomorrowsAppointments();
        for (int i = 0; i < tomorrows.size(); i++) {
            String info = tomorrows.get(i);
            String[] split = info.split(", ");
            String date = split[0];
            String time = split[1];
            String email = split[2];
            System.out.println("@" + email + " Husk din tid hos HårMonika, " + date + " kl: " + time);
        }
    }
    public String showTomorrowsDate(){
        LocalDate today = LocalDate.now();
        return today.plusDays(1).toString();
    }
    public List<String> getTomorrowsAppointments(){
        String fortnite = showTomorrowsDate();
        List<String> tomorrows = DatabaseManager.getTomorrowsAppointments(fortnite);
        return tomorrows;
    }
    public Time sendTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 17);
        calendar.set(Calendar.MINUTE, 46);
        calendar.set(Calendar.SECOND, 0);
        return new Time(calendar.getTimeInMillis());
    }
    public void sendEmails(){
        Date alarm = sendTime();
        Timer timer = new Timer();
        TimerTask sendEmail = new Email();
        timer.schedule(sendEmail, alarm);
    }
}

