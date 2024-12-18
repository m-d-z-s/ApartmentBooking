package me.mdzs.apartmentbooking.app.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", "Hello, Ira!");
        return "greeting"; // Возвращает имя представления
    }
}
