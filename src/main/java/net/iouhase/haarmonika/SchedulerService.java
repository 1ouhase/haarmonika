package net.iouhase.haarmonika;

import net.iouhase.haarmonika.model.Email;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SchedulerService {
    public Time sendTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 29);
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
