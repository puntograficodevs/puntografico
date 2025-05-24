package com.puntografico.pm.repository;

import com.puntografico.pm.domain.Impresion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpresionRepository extends JpaRepository<Impresion, Long> {
}
