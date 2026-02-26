package com.pizza.pizzashop.controller;  // apne project ke hisab se adjust karo

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Pizza Shop Backend Running Successfully 🚀";
    }
}
