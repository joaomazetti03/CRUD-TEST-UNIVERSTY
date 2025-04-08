package com.example.provacrud.Service;

import com.example.provacrud.Repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;


}
