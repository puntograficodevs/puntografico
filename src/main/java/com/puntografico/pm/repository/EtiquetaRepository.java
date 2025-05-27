package com.puntografico.pm.repository;

import com.puntografico.pm.domain.Etiqueta;
import com.puntografico.pm.domain.Papeleria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
