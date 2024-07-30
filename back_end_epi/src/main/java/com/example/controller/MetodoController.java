package com.example.controller;

import com.example.dto.MetodoDTO;
import com.example.service.MetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodos")
public class MetodoController {

    @Autowired
    private MetodoService metodoService;

    @GetMapping("/id/{id}")
    public MetodoDTO getMetodoById(@PathVariable Long id) {
        return metodoService.getMetodoById(id);
    }

    @PostMapping("/crear")
    public MetodoDTO createMetodo(@RequestBody MetodoDTO metodoDTO) {
        return metodoService.saveMetodo(metodoDTO);
    }

    @PutMapping("/actualizar/{id}")
    public MetodoDTO updateMetodo(@PathVariable Long id, @RequestBody MetodoDTO metodoDTO) {
        metodoDTO.setId_metodo(id);
        return metodoService.saveMetodo(metodoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteMetodo(@PathVariable Long id) {
        metodoService.deleteMetodo(id);
    }

    @GetMapping
    public List<MetodoDTO> getAllMetodos() {
        return metodoService.getAllMetodos();
    }
}
