package com.puntografico.pm.repository;

import com.puntografico.pm.domain.Talonario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalonarioRepository extends JpaRepository<Talonario, Long> {
}
