package com.puntografico.pm.service;

import com.puntografico.pm.domain.Papeleria;
import com.puntografico.pm.repository.PapeleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PapeleriaService {

    @Autowired
    private PapeleriaRepository papeleriaRepository;

    public Papeleria guardar(Papeleria papeleria) {
        return papeleriaRepository.save(papeleria);
    }

    public Papeleria buscarPorId(Long id) {
        return papeleriaRepository.findById(id).get();
    }
}
