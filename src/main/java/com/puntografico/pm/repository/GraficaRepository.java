package com.puntografico.pm.repository;

import com.puntografico.pm.domain.Grafica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraficaRepository extends JpaRepository<Grafica, Long> {
}
