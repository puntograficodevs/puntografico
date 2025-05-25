package com.puntografico.pm.repository;

import com.puntografico.pm.domain.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Long> {

    List<OrdenTrabajo> findAllById(Long id);
    List<OrdenTrabajo> findAllByClienteNombre(String clienteNombre);
    List<OrdenTrabajo> findAllByClienteTelefono(String clienteTelefono);
}
