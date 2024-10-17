module apartmentbooking {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.core;
    requires spring.beans;
    requires spring.web;

    requires javafx.controls;
    requires javafx.fxml;




    opens me.mdzs.apartmentbooking.app.desktop.controllers to javafx.fxml;
    exports me.mdzs.apartmentbooking.app.desktop.controllers;

    opens me.mdzs.apartmentbooking.app.desktop to javafx.fxml;
    exports me.mdzs.apartmentbooking.app.desktop;
    opens me.mdzs.apartmentbooking.domain to javafx.fxml;
    exports me.mdzs.apartmentbooking.domain;
}