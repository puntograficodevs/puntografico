package com.puntografico.pm.repository;

import com.puntografico.pm.domain.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer> {

    List<CategoriaProducto> findAll();
    CategoriaProducto findByIdCategoriaProducto(Integer idCategoriaProducto);
}
