package com.example.controller;

import com.example.dto.TipoCalculoDTO;
import com.example.service.TipoCalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-calculos")
public class TipoCalculoController {

    @Autowired
    private TipoCalculoService tipoCalculoService;

    @GetMapping("/id/{id}")
    public ResponseEntity<TipoCalculoDTO> getTipoCalculoById(@PathVariable Long id) {
        TipoCalculoDTO tipoCalculoDTO = tipoCalculoService.getTipoCalculoById(id);
        return ResponseEntity.ok(tipoCalculoDTO);
    }

    @GetMapping
    public ResponseEntity<List<TipoCalculoDTO>> getAllTipoCalculos() {
        List<TipoCalculoDTO> tipoCalculos = tipoCalculoService.getAllTipoCalculos();
        return ResponseEntity.ok(tipoCalculos);
    }

    @PostMapping("/crear")
    public ResponseEntity<TipoCalculoDTO> createTipoCalculo(@RequestBody TipoCalculoDTO tipoCalculoDTO) {
        TipoCalculoDTO nuevoTipoCalculo = tipoCalculoService.saveTipoCalculo(tipoCalculoDTO);
        return ResponseEntity.ok(nuevoTipoCalculo);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TipoCalculoDTO> updateTipoCalculo(@PathVariable Long id, @RequestBody TipoCalculoDTO tipoCalculoDTO) {
        TipoCalculoDTO tipoCalculoActualizado = tipoCalculoService.updateTipoCalculo(id, tipoCalculoDTO);
        return ResponseEntity.ok(tipoCalculoActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteTipoCalculo(@PathVariable Long id) {
        tipoCalculoService.deleteTipoCalculo(id);
        return ResponseEntity.noContent().build();
    }
}
