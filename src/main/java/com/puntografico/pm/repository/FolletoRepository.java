package com.puntografico.pm.repository;

import com.puntografico.pm.domain.Folleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolletoRepository extends JpaRepository<Folleto, Long> {
}
