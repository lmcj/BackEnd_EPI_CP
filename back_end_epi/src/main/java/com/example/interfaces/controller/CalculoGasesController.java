package com.example.interfaces.controller;

import com.example.application.dto.CalculoGasesDTO;
import com.example.domain.service.CalculoGasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculoGases")
public class CalculoGasesController {

    @Autowired
    private CalculoGasesService calculoGasesService;

    @GetMapping("/id/{id}")
    public ResponseEntity<CalculoGasesDTO> getCalculoGasesById(@PathVariable Long id) {
        CalculoGasesDTO calculoGasesDTO = calculoGasesService.getCalculoGasesById(id);
        return ResponseEntity.ok(calculoGasesDTO);
    }

    @PostMapping("/crear")
    public ResponseEntity<CalculoGasesDTO> createCalculoGases(@RequestBody CalculoGasesDTO calculoGasesDTO) {
        CalculoGasesDTO savedCalculoGasesDTO = calculoGasesService.saveCalculoGasesWithGrupos(calculoGasesDTO);
        return ResponseEntity.ok(savedCalculoGasesDTO);
    }

    @PostMapping("/crear_resultados")
    public ResponseEntity<CalculoGasesDTO> createCalculoGasesResultados(@RequestBody CalculoGasesDTO calculoGasesDTO) {
        CalculoGasesDTO savedCalculoGasesDTO = calculoGasesService.saveCalculoGasesWithGrupos(calculoGasesDTO);
        return ResponseEntity.ok(savedCalculoGasesDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteCalculoGases(@PathVariable Long id) {
        calculoGasesService.deleteCalculoGases(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CalculoGasesDTO>> getAllCalculosGases() {
        List<CalculoGasesDTO> calculosGases = calculoGasesService.getAllCalculoGases();
        return ResponseEntity.ok(calculosGases);
    }
}
