package com.puntografico.pm.service;

import com.puntografico.pm.domain.Etiqueta;
import com.puntografico.pm.repository.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaService {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    public Etiqueta guardar(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    public Etiqueta buscarPorId(Long id) {
        return etiquetaRepository.findById(id).get();
    }
}
