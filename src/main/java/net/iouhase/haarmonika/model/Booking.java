package net.iouhase.haarmonika.model;

import java.util.Date;

public class Booking {
    int id;
    Date dato;
    int tid;
    String navn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Boolean getAflysning() {
        return aflysning;
    }

    public void setAflysning(Boolean aflysning) {
        this.aflysning = aflysning;
    }

    public Booking(Date dato, int tid, String navn, Boolean aflysning) {
        this.dato = dato;
        this.tid = tid;
        this.navn = navn;
        this.aflysning = aflysning;
    }

    Boolean aflysning;

    public Booking(int id, Date dato, int tid, String navn, Boolean aflysning) {
        this.id = id;
        this.dato = dato;
        this.tid = tid;
        this.navn = navn;
        this.aflysning = aflysning;
    }
}
