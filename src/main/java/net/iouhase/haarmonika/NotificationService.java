package net.iouhase.haarmonika;

import net.iouhase.haarmonika.database.DatabaseManager;

import java.time.LocalDate;
import java.util.List;

public class NotificationService {
    public String notifyOfBooking(String email) {//Sender når man trykker i adminView
//        System.out.println("Husk din tid hos HårMonika, " + email + " " + DatabaseManager.getTime(email));
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
}
