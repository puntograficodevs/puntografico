package com.puntografico.pm.controller;

import com.puntografico.pm.domain.Empleado;
import com.puntografico.pm.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String key, @RequestParam(required = false) String username, Model model) {
        if (key == null || !key.equals("asdghaer123riuhy12o34y12fh")) {
            return "redirect:/";
        }
        Empleado empleado = empleadoService.traerSegunUsername(username).get();

        model.addAttribute("empleado", empleado);
        model.addAttribute("nombreEmpleado", formatearNombre(empleado.getNombre()));
        return "home";
    }

    private String formatearNombre(String nombre){
        return nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
    }
}
