package com.puntografico.pm.controller;

import com.puntografico.pm.domain.CategoriaProducto;
import com.puntografico.pm.domain.Etiqueta;
import com.puntografico.pm.domain.Papeleria;
import com.puntografico.pm.service.CategoriaProductoService;
import com.puntografico.pm.service.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EtiquetaController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @Autowired
    private EtiquetaService etiquetaService;

    @PostMapping("/guardar-etiqueta")
    @ResponseBody
    public Etiqueta guardar(@ModelAttribute Etiqueta etiqueta) {
        CategoriaProducto categoriaProducto = categoriaProductoService.buscarPorId(12);
        etiqueta.setCategoriaProducto(categoriaProducto);
        return etiquetaService.guardar(etiqueta);
    }
}
