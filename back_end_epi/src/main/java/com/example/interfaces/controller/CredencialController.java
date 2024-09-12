package com.example.interfaces.controller;

import com.example.application.dto.CredencialDTO;
import com.example.application.service.CredencialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credenciales")
public class CredencialController {

    @Autowired
    private CredencialService credencialService;

    @GetMapping("/id/{id}")
    public CredencialDTO getCredencialById(@PathVariable Long id) {
        return credencialService.getCredencialById(id);
    }

    @PostMapping("/crear")
    public CredencialDTO createCredencial(@RequestBody CredencialDTO credencialDTO) {
        return credencialService.saveCredencial(credencialDTO);
    }

    @PutMapping("/actualizar/{id}")
    public CredencialDTO updateCredencial(@PathVariable Long id, @RequestBody CredencialDTO credencialDTO) {
        credencialDTO.setId_credencial(id);
        return credencialService.saveCredencial(credencialDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteCredencial(@PathVariable Long id) {
        credencialService.deleteCredencial(id);
    }

    @GetMapping
    public List<CredencialDTO> getAllCredenciales() {
        return credencialService.getAllCredenciales();
    }
}
