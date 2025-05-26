package com.puntografico.pm.repository;

import com.puntografico.pm.domain.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Long> {
    @Query("SELECT ot FROM OrdenTrabajo ot WHERE ot.clienteNombre LIKE CONCAT('%', :clienteNombre, '%')")
    List<OrdenTrabajo> findAllByClienteNombre(@Param("clienteNombre") String clienteNombre);

    @Query("SELECT ot FROM OrdenTrabajo ot WHERE ot.clienteTelefono LIKE CONCAT('%', :clienteTelefono, '%')")
    List<OrdenTrabajo> findAllByClienteTelefono(@Param("clienteTelefono") String clienteTelefono);
}
