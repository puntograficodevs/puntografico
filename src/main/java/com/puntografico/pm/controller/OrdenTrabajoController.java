package com.puntografico.pm.controller;

import com.puntografico.pm.domain.Empleado;
import com.puntografico.pm.domain.CategoriaProducto;
import com.puntografico.pm.domain.OrdenTrabajo;
import com.puntografico.pm.domain.Papeleria;
import com.puntografico.pm.service.EmpleadoService;
import com.puntografico.pm.service.CategoriaProductoService;
import com.puntografico.pm.service.OrdenTrabajoService;
import com.puntografico.pm.service.PapeleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class OrdenTrabajoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private OrdenTrabajoService ordenTrabajoService;

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @Autowired
    private PapeleriaService papeleriaService;

    @GetMapping("/crear-orden")
    public String crearOrden(@RequestParam(required = false) String key, @RequestParam(required = false) String username, Model model) {
        if (key == null || !key.equals("asdghaer123riuhy12o34y12fh")) {
            return "redirect:/";
        }

        Empleado empleado = empleadoService.traerSegunUsername(username).get();
        List<CategoriaProducto> categoriasProductos = categoriaProductoService.buscarTodos();

        model.addAttribute("empleado", empleado);
        model.addAttribute("categoriasProductos", categoriasProductos);
        return "crear-orden";
    }

    @PostMapping("/guardar-orden")
    public String guardar(RedirectAttributes redirectAttributes,
                          @ModelAttribute OrdenTrabajo ordenTrabajo,
                          @RequestParam Long empleadoId,
                          @RequestParam Integer categoriaProductoId,
                          @RequestParam(required = false) Long papeleriaId) {

        Empleado empleado = empleadoService.buscarPorId(empleadoId);
        CategoriaProducto categoriaProducto = categoriaProductoService.buscarPorId(categoriaProductoId);
        if (papeleriaId != null) {
            Papeleria papeleria = papeleriaService.buscarPorId(papeleriaId);
            ordenTrabajo.setPapeleria(papeleria);
        }
        ordenTrabajo.setEmpleado(empleado);
        ordenTrabajo.setCategoriaProducto(categoriaProducto);

        ordenTrabajo = ordenTrabajoService.guardar(ordenTrabajo);

        redirectAttributes.addFlashAttribute("ordenTrabajo", ordenTrabajo);

        return "redirect:/home?key=asdghaer123riuhy12o34y12fh&username=" + empleado.getUsername();
    }
}
