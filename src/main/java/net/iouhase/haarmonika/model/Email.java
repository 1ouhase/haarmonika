package net.iouhase.haarmonika.model;

import net.iouhase.haarmonika.UseCase;

import java.util.TimerTask;

public class Email extends TimerTask {
    UseCase useCase = new UseCase();

    public void run(){
        useCase.autoNotify();
    }
}