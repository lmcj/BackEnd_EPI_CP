package com.example.controller;

import com.example.dto.AuxiliarMetodosDTO;
import com.example.service.AuxiliarMetodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auxiliares-metodos")
public class AuxiliarMetodosController {

    @Autowired
    private AuxiliarMetodosService auxiliarMetodosService;

    @GetMapping("/id/{id}")
    public AuxiliarMetodosDTO getAuxiliarMetodosById(@PathVariable Long id) {
        return auxiliarMetodosService.getAuxiliarMetodosById(id);
    }

    @PostMapping("/crear")
    public AuxiliarMetodosDTO createAuxiliarMetodos(@RequestBody AuxiliarMetodosDTO auxiliarMetodosDTO) {
        return auxiliarMetodosService.saveAuxiliarMetodos(auxiliarMetodosDTO);
    }

    @PutMapping("/actualizar/{id}")
    public AuxiliarMetodosDTO updateAuxiliarMetodos(@PathVariable Long id, @RequestBody AuxiliarMetodosDTO auxiliarMetodosDTO) {
        auxiliarMetodosDTO.setId_auxiliar_metodos(id);
        return auxiliarMetodosService.saveAuxiliarMetodos(auxiliarMetodosDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteAuxiliarMetodos(@PathVariable Long id) {
        auxiliarMetodosService.deleteAuxiliarMetodos(id);
    }

    @GetMapping
    public List<AuxiliarMetodosDTO> getAllAuxiliaresMetodos() {
        return auxiliarMetodosService.getAllAuxiliaresMetodos();
    }
}
