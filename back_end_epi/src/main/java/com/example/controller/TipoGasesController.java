package com.example.controller;

import com.example.dto.TipoGasesDTO;
import com.example.service.TipoGasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-gases")
public class TipoGasesController {

    @Autowired
    private TipoGasesService tipoGasesService;

    @GetMapping("/id/{id}")
    public ResponseEntity<TipoGasesDTO> getTipoGasesById(@PathVariable Long id) {
        TipoGasesDTO tipoGasesDTO = tipoGasesService.getTipoGasesById(id);
        return ResponseEntity.ok(tipoGasesDTO);
    }

    @GetMapping
    public ResponseEntity<List<TipoGasesDTO>> getAllTipoGases() {
        List<TipoGasesDTO> tipoGases = tipoGasesService.getAllTipoGases();
        return ResponseEntity.ok(tipoGases);
    }

    @PostMapping("/crear")
    public ResponseEntity<TipoGasesDTO> createTipoGases(@RequestBody TipoGasesDTO tipoGasesDTO) {
        TipoGasesDTO nuevoTipoGases = tipoGasesService.saveTipoGases(tipoGasesDTO);
        return ResponseEntity.ok(nuevoTipoGases);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TipoGasesDTO> updateTipoGases(@PathVariable Long id, @RequestBody TipoGasesDTO tipoGasesDTO) {
        TipoGasesDTO tipoGasesActualizado = tipoGasesService.updateTipoGases(id, tipoGasesDTO);
        return ResponseEntity.ok(tipoGasesActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteTipoGases(@PathVariable Long id) {
        tipoGasesService.deleteTipoGases(id);
        return ResponseEntity.noContent().build();
    }
}
