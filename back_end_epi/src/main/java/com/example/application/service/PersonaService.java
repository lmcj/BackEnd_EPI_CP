package com.example.application.service;

import com.example.domain.model.Persona;
import com.example.application.dto.PersonaDTO;
import com.example.application.mapper.PersonaMapper;
import com.example.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaDTO getPersonaById(Long id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        return PersonaMapper.INSTANCE.personaToPersonaDTO(persona);
    }

    public PersonaDTO savePersona(PersonaDTO personaDTO) {
        Persona persona = PersonaMapper.INSTANCE.personaDTOToPersona(personaDTO);
        persona = personaRepository.save(persona);
        return PersonaMapper.INSTANCE.personaToPersonaDTO(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    public List<PersonaDTO> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream()
                .map(PersonaMapper.INSTANCE::personaToPersonaDTO)
                .collect(Collectors.toList());
    }
}
