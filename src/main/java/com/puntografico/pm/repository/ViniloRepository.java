package com.puntografico.pm.repository;

import com.puntografico.pm.domain.Vinilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViniloRepository extends JpaRepository<Vinilo, Long> {
}
