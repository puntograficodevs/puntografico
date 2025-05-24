package com.puntografico.pm.repository;

import com.puntografico.pm.domain.OtroProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtroProductoRepository extends JpaRepository<OtroProducto, Long> {
}
