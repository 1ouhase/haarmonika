package net.iouhase.haarmonika;

import java.util.TimerTask;

public class Email extends TimerTask {
    UseCase useCase = new UseCase();

    public void run(){
        useCase.autoNotify();
    }
}