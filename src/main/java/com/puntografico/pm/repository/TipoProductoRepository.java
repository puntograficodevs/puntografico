package com.puntografico.pm.repository;

import com.puntografico.pm.domain.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {

    List<TipoProducto> findAll();
}
