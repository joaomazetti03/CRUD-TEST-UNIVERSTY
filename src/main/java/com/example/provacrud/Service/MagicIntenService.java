package com.example.provacrud.Service;

import com.example.provacrud.Model.MagicIten;
import com.example.provacrud.Repository.MagicItenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagicIntenService {

    @Autowired
    MagicItenRepository magicItenRepository;

    public List<MagicIten> listMagicIten() {
        return magicItenRepository.findAll();
    }

    public MagicIten getMagicItenById(Long id) {
        return magicItenRepository.findById(id).orElse(null);
    }

    public MagicIten insertMagicIten(MagicIten magicIten) {
        return magicItenRepository.save(magicIten);
    }

    public MagicIten saveMagicIten(MagicIten magicIten) {
        return magicItenRepository.save(magicIten);
    }
}
