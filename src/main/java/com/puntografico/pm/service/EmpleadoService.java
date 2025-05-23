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

    public Optional<Empleado> traerEmpleado(String username, String password){
        return empleadoRepository.findByUsernameAndPassword(username, password);
    }
}
