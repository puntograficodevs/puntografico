package com.puntografico.pm.repository;

import com.puntografico.pm.domain.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Long> {
}
