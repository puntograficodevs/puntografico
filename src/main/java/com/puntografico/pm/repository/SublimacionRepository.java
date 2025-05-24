package com.puntografico.pm.repository;

import com.puntografico.pm.domain.Sublimacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SublimacionRepository extends JpaRepository<Sublimacion, Long> {
}
