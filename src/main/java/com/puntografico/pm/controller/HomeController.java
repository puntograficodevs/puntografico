package com.puntografico.pm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(@RequestParam(required = false) String key) {
        if (key == null || !key.equals("asdghaer123riuhy12o34y12fh")) {
            return "redirect:/";
        }
        return "home";
    }
}
