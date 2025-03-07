package net.iouhase.haarmonika.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Time;
import java.util.Date;

public class Booking {
    int id;
    Date dato;
    Time tid;
    Time varihed;
    String type;
    String frisør;
    String navn;
    boolean aflysning;

    public int getId() {
        return id;
    }

    public Date getDato() {
        return dato;
    }

    public Time getTid() {
        return tid;
    }

    public Time getVarihed() {
        return varihed;
    }

    public String getType() {
        return type;
    }

    public String getFrisør(){
        return frisør;
    }

    public String getNavn() {
        return navn;
    }

    public Boolean getAflysning() {
        return aflysning;
    }

    public void setFrisør(String frisør){
        this.frisør = frisør;
    }

    public void setType(final String type) {
        this.type = type;
    }
    public void setVarihed(final Time varihed) {
        this.varihed = varihed;
    }

    public StringProperty datoProperty() {
        return new SimpleStringProperty(dato.toString());
    }

    public StringProperty tidProperty() {
        return new SimpleStringProperty(tid.toString());
    }

    public StringProperty varihedProperty() {
        return new SimpleStringProperty(varihed.toString());
    }

    public StringProperty typeProperty() {
        return new SimpleStringProperty(type);
    }

    public StringProperty frisørProperty() {
        return new SimpleStringProperty(frisør);
    }

    public StringProperty navnProperty() {
        return new SimpleStringProperty(navn);
    }

    public BooleanProperty aflysningProperty() {
        return new SimpleBooleanProperty(aflysning);
    }

    public Booking(Date dato, Time tid, String type, String frisør, String navn, Time varihed, Boolean aflysning) {
        this.dato = dato;
        this.tid = tid;
        this.type = type;
        this.frisør = frisør;
        this.navn = navn;
        this.aflysning = aflysning;
        this.varihed = varihed;
    }

    public Booking(int id, Date dato, Time tid, String type, String frisør, String navn, Time Varighed, Boolean aflysning) {
        this.id = id;
        this.dato = dato;
        this.tid = tid;
        this.type = type;
        this.frisør = frisør;
        this.navn = navn;
        this.aflysning = aflysning;
        this.varihed = Varighed;
    }
}
