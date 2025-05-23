package com.puntografico.pm.controller;

import com.puntografico.pm.domain.Empleado;
import com.puntografico.pm.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<Empleado> empleado = empleadoService.traerUsuarioValido(username, password);

        if (empleado.isPresent()) {
            return "redirect:/home?key=asdghaer123riuhy12o34y12fh&username=" + username;
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }
}
