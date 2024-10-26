package me.mdzs.apartmentbooking.app.spring.controller;

import me.mdzs.apartmentbooking.app.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

//    @GetMapping("/hello")
//    public String sayHello() {
//        return loginService.getHelloMessage();
//    }

}
