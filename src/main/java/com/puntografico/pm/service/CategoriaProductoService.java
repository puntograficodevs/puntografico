package com.puntografico.pm.service;

import com.puntografico.pm.domain.CategoriaProducto;
import com.puntografico.pm.repository.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoService {
    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    public List<CategoriaProducto> buscarTodos(){
        return categoriaProductoRepository.findAll();
    }
}
