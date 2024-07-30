package com.example.controller;

import com.example.dto.CalculoPoblacionalDTO;
import com.example.service.CalculoPoblacionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculos-poblacionales")
public class CalculoPoblacionalController {

    @Autowired
    private CalculoPoblacionalService calculoPoblacionalService;

    @GetMapping("/id/{id}")
    public CalculoPoblacionalDTO getCalculoPoblacionalById(@PathVariable Long id) {
        return calculoPoblacionalService.getCalculoPoblacionalById(id);
    }

    @PostMapping("/crear")
    public CalculoPoblacionalDTO createCalculoPoblacional(@RequestBody CalculoPoblacionalDTO calculoPoblacionalDTO) {
        return calculoPoblacionalService.saveCalculoPoblacional(calculoPoblacionalDTO);
    }

    @PutMapping("/actualizar/{id}")
    public CalculoPoblacionalDTO updateCalculoPoblacional(@PathVariable Long id, @RequestBody CalculoPoblacionalDTO calculoPoblacionalDTO) {
        calculoPoblacionalDTO.setId_calculo_poblacional(id);
        return calculoPoblacionalService.saveCalculoPoblacional(calculoPoblacionalDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteCalculoPoblacional(@PathVariable Long id) {
        calculoPoblacionalService.deleteCalculoPoblacional(id);
    }

    @GetMapping
    public List<CalculoPoblacionalDTO> getAllCalculosPoblacionales() {
        return calculoPoblacionalService.getAllCalculosPoblacionales();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<CalculoPoblacionalDTO> getCalculoPoblacionalByUsuario(@PathVariable Long idUsuario) {
        return calculoPoblacionalService.getCalculoPoblacionalByUsuario(idUsuario);
    }
}
