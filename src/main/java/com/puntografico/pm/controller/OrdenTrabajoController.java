package com.puntografico.pm.controller;

import com.puntografico.pm.domain.*;
import com.puntografico.pm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private EtiquetaService etiquetaService;

    @Autowired
    private StickerService stickerService;

    @GetMapping("/crear-orden")
    public String crear(@RequestParam(required = false) String key, @RequestParam(required = false) String username, Model model) {
        if (key == null || !key.equals("asdghaer123riuhy12o34y12fh")) {
            return "redirect:/";
        }

        Empleado empleado = empleadoService.traerSegunUsername(username).get();
        List<CategoriaProducto> categoriasProductos = categoriaProductoService.buscarTodos();

        model.addAttribute("nombreEmpleado", formatearNombre(empleado.getNombre()));
        model.addAttribute("empleado", empleado);
        model.addAttribute("categoriasProductos", categoriasProductos);
        return "crear-orden";
    }

    @PostMapping("/guardar-orden")
    public String guardar(RedirectAttributes redirectAttributes,
                          @ModelAttribute OrdenTrabajo ordenTrabajo,
                          @RequestParam Long empleadoId,
                          @RequestParam Integer categoriaProductoId,
                          @RequestParam(required = false) Long etiquetaId,
                          @RequestParam(required = false) Long stickerId) {

        Empleado empleado = empleadoService.buscarPorId(empleadoId);
        CategoriaProducto categoriaProducto = categoriaProductoService.buscarPorId(categoriaProductoId);

        if (etiquetaId != null) {
            Etiqueta etiqueta = etiquetaService.buscarPorId(etiquetaId);
            ordenTrabajo.setEtiqueta(etiqueta);
        } else if (stickerId != null) {
            Sticker sticker = stickerService.buscarPorId(stickerId);
            ordenTrabajo.setSticker(sticker);
        }

        ordenTrabajo.setEmpleado(empleado);
        ordenTrabajo.setCategoriaProducto(categoriaProducto);

        ordenTrabajo = ordenTrabajoService.guardar(ordenTrabajo);

        redirectAttributes.addFlashAttribute("ordenTrabajo", ordenTrabajo);

        return "redirect:/home?key=asdghaer123riuhy12o34y12fh&username=" + empleado.getUsername();
    }

    @GetMapping("/buscar-orden")
    public String buscarOrdenes(@RequestParam String tipo,
                                @RequestParam String valor,
                                @RequestParam String key,
                                Model model) {
        if (key == null || !key.equals("asdghaer123riuhy12o34y12fh")) {
            return "fragments/tabla-ordenes :: tablaOrdenesFragment"; // vacía o con mensaje
        }

        List<OrdenTrabajo> ordenes = ordenTrabajoService.buscarPorIdClienteNombreOClienteTelefono(tipo, valor);
        model.addAttribute("ordenes", ordenes);
        return "fragments/tabla-ordenes :: tablaOrdenesFragment";
    }

    private String formatearNombre(String nombre){
        return nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
    }
}
