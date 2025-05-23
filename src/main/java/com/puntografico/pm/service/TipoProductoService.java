package com.puntografico.pm.service;

import com.puntografico.pm.domain.TipoProducto;
import com.puntografico.pm.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoService {
    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    public List<TipoProducto> buscarTodos(){
        return tipoProductoRepository.findAll();
    }
}
