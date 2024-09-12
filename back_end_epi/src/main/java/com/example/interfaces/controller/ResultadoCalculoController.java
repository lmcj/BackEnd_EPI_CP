package com.example.interfaces.controller;

import com.example.application.dto.ResultadoCalculoDTO;
import com.example.domain.service.ResultadoCalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultadoCalculo")
public class ResultadoCalculoController {

    @Autowired
    private ResultadoCalculoService resultadoCalculoService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ResultadoCalculoDTO> getResultadoCalculoById(@PathVariable Long id) {
        ResultadoCalculoDTO resultadoCalculoDTO = resultadoCalculoService.getResultadoCalculoById(id);
        return ResponseEntity.ok(resultadoCalculoDTO);
    }

    @PostMapping("/crear")
    public ResponseEntity<ResultadoCalculoDTO> createResultadoCalculo(@RequestBody ResultadoCalculoDTO resultadoCalculoDTO) {
        ResultadoCalculoDTO savedResultadoCalculoDTO = resultadoCalculoService.saveResultadoCalculo(resultadoCalculoDTO);
        return ResponseEntity.ok(savedResultadoCalculoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteResultadoCalculo(@PathVariable Long id) {
        resultadoCalculoService.deleteResultadoCalculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ResultadoCalculoDTO>> getAllResultadosCalculo() {
        List<ResultadoCalculoDTO> resultadosCalculo = resultadoCalculoService.getAllResultadosCalculo();
        return ResponseEntity.ok(resultadosCalculo);
    }
}
