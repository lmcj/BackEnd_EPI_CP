package com.example.interfaces.controller;

import com.example.application.dto.PersonaDTO;
import com.example.application.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/id/{id}")
    public PersonaDTO getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id);
    }

    @PostMapping("/crear")
    public PersonaDTO createPersona(@RequestBody PersonaDTO personaDTO) {
        return personaService.savePersona(personaDTO);
    }

    @PutMapping("/actualizar/{id}")
    public PersonaDTO updatePersona(@PathVariable Long id, @RequestBody PersonaDTO personaDTO) {
        personaDTO.setId_persona(id);
        return personaService.savePersona(personaDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }

    @GetMapping
    public List<PersonaDTO> getAllPersonas() {
        return personaService.getAllPersonas();
    }
}

