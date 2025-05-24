package com.puntografico.pm.repository;

import com.puntografico.pm.domain.Sello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelloRepository extends JpaRepository<Sello, Long> {
}
