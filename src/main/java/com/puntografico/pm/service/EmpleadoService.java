package com.puntografico.pm.service;

import com.puntografico.pm.domain.Empleado;
import com.puntografico.pm.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Optional<Empleado> traerUsuarioValido(String username, String password) {
        return empleadoRepository.findByUsernameAndPassword(username, password);
    }

    public Optional<Empleado> traerSegunUsername(String username) {
        return empleadoRepository.findByUsername(username);
    }

    public Empleado buscarPorId(Long id) {
        return empleadoRepository.findById(id).get();
    }
}
