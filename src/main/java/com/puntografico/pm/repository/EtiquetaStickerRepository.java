package com.puntografico.pm.repository;

import com.puntografico.pm.domain.EtiquetaSticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaStickerRepository extends JpaRepository<EtiquetaSticker, Long> {
}
