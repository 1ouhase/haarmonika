module net.iouhase.haarmonika {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens net.iouhase.haarmonika to javafx.fxml;
    exports net.iouhase.haarmonika;
    exports net.iouhase.haarmonika.model;
    opens net.iouhase.haarmonika.model to javafx.fxml;
}