package com.example.provacrud.Service;

import com.example.provacrud.Model.MagicIten;
import com.example.provacrud.Repository.MagicItenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagicIntenService {

    @Autowired
    MagicItenRepository magicItenRepository;

    public List<MagicIten> listMagicIten() {
        return magicItenRepository.findAll();
    }

    public Optional<MagicIten> getMagicItenById(Long magicItenId) {
        return magicItenRepository.findById(magicItenId);
    }

    public List<MagicIten> findByCharacterId(Long characterId) {
        return magicItenRepository.findByCharacterId(characterId);
    }

    public MagicIten insertMagicIten(MagicIten magicIten) {
        return magicItenRepository.save(magicIten);
    }

    public MagicIten saveMagicIten(MagicIten magicIten) {
        return magicItenRepository.save(magicIten);
    }

    public void deleteMagicItenById(Long magicItenId) {
        magicItenRepository.deleteById(magicItenId);
    }
}
