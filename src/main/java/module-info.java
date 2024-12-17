module apartmentbooking {
    requires spring.boot;
    requires spring.beans;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.core;
    requires spring.web;
    requires javafx.controls;
    requires javafx.fxml;
    requires thymeleaf.spring5;
    requires thymeleaf;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;
    requires java.sql;


    opens me.mdzs.apartmentbooking.app.desktop.controllers to javafx.fxml;
    exports me.mdzs.apartmentbooking.app.desktop.controllers;

    opens me.mdzs.apartmentbooking.app.desktop to javafx.fxml;
    exports me.mdzs.apartmentbooking.app.desktop;

    opens me.mdzs.apartmentbooking.domain to javafx.fxml, com.google.gson;
    exports me.mdzs.apartmentbooking.domain;



//    opens me.mdzs.apartmentbooking.app.spring to spring.core, spring.beans;
//    exports me.mdzs.apartmentbooking.app.spring;
//
//    opens me.mdzs.apartmentbooking.app.spring.service to spring.core, spring.beans;
//    exports me.mdzs.apartmentbooking.app.spring.service;
//
//    opens me.mdzs.apartmentbooking.app.spring.controller to spring.core, spring.beans;
//    exports me.mdzs.apartmentbooking.app.spring.controller;

}