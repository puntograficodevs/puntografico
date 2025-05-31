package com.puntografico.pm.controller;

import com.puntografico.pm.domain.CategoriaProducto;
import com.puntografico.pm.domain.Sticker;
import com.puntografico.pm.service.CategoriaProductoService;
import com.puntografico.pm.service.StickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StickerController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @Autowired
    private StickerService stickerService;

    @PostMapping("/guardar-sticker")
    @ResponseBody
    public Sticker guardar(@ModelAttribute Sticker sticker) {
        CategoriaProducto categoriaProducto = categoriaProductoService.buscarPorId(13);
        sticker.setCategoriaProducto(categoriaProducto);
        return stickerService.guardar(sticker);
    }
}
