package com.puntografico.pm.service;

import com.puntografico.pm.domain.Sticker;
import com.puntografico.pm.repository.StickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StickerService {

    @Autowired
    private StickerRepository stickerRepository;

    public Sticker guardar(Sticker sticker) {
        return stickerRepository.save(sticker);
    }

    public Sticker buscarPorId(Long id) {
        return stickerRepository.findById(id).get();
    }
}
