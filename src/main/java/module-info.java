module org.example.java142_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.apache.commons.pool2;
    requires commons.dbcp2;
    requires java.naming;
    requires java.management;

    opens org.example.java142_project to javafx.fxml;
    opens org.example.java142_project.entity to javafx.base;

    exports org.example.java142_project;
    exports org.example.java142_project.controller;
    opens org.example.java142_project.controller to javafx.fxml;
}