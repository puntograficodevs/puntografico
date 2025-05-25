package com.puntografico.pm.controller;

import com.puntografico.pm.domain.CategoriaProducto;
import com.puntografico.pm.domain.Papeleria;
import com.puntografico.pm.service.CategoriaProductoService;
import com.puntografico.pm.service.PapeleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PapeleriaController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @Autowired
    private PapeleriaService papeleriaService;

    @PostMapping("/guardar-papeleria")
    @ResponseBody
    public Papeleria guardar(@ModelAttribute Papeleria papeleria) {
        CategoriaProducto categoriaProducto = categoriaProductoService.buscarPorId(2);
        papeleria.setCategoriaProducto(categoriaProducto);
        return papeleriaService.guardar(papeleria);
    }
}
