package com.example.controller;

import com.example.dto.TipoMetodoDTO;
import com.example.service.TipoMetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-metodo")
public class TipoMetodoController {

    @Autowired
    private TipoMetodoService tipoMetodoService;

    @GetMapping("/id/{id}")
    public ResponseEntity<TipoMetodoDTO> getTipoMetodoById(@PathVariable Long id) {
        TipoMetodoDTO tipoMetodoDTO = tipoMetodoService.getTipoMetodoById(id);
        return ResponseEntity.ok(tipoMetodoDTO);
    }

    @GetMapping
    public ResponseEntity<List<TipoMetodoDTO>> getAllTipoMetodos() {
        List<TipoMetodoDTO> tipoMetodos = tipoMetodoService.getAllTipoMetodos();
        return ResponseEntity.ok(tipoMetodos);
    }

    @PostMapping("/crear")
    public ResponseEntity<TipoMetodoDTO> createTipoMetodo(@RequestBody TipoMetodoDTO tipoMetodoDTO) {
        TipoMetodoDTO nuevoTipoMetodo = tipoMetodoService.saveTipoMetodo(tipoMetodoDTO);
        return ResponseEntity.ok(nuevoTipoMetodo);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TipoMetodoDTO> updateTipoMetodo(@PathVariable Long id, @RequestBody TipoMetodoDTO tipoMetodoDTO) {
        TipoMetodoDTO tipoMetodoActualizado = tipoMetodoService.updateTipoMetodo(id, tipoMetodoDTO);
        return ResponseEntity.ok(tipoMetodoActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteTipoMetodo(@PathVariable Long id) {
        tipoMetodoService.deleteTipoMetodo(id);
        return ResponseEntity.noContent().build();
    }
}
