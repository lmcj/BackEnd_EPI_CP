package com.example.controller;

import com.example.dto.TipoMedidaDTO;
import com.example.service.TipoMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-medida")
public class TipoMedidaController {

    @Autowired
    private TipoMedidaService tipoMedidaService;

    @GetMapping("/id/{id}")
    public ResponseEntity<TipoMedidaDTO> getTipoMedidaById(@PathVariable Long id) {
        TipoMedidaDTO tipoMedidaDTO = tipoMedidaService.getTipoMedidaById(id);
        return ResponseEntity.ok(tipoMedidaDTO);
    }

    @GetMapping
    public ResponseEntity<List<TipoMedidaDTO>> getAllTipoMedidas() {
        List<TipoMedidaDTO> tipoMedidas = tipoMedidaService.getAllTipoMedidas();
        return ResponseEntity.ok(tipoMedidas);
    }

    @PostMapping("/crear")
    public ResponseEntity<TipoMedidaDTO> createTipoMedida(@RequestBody TipoMedidaDTO tipoMedidaDTO) {
        TipoMedidaDTO nuevoTipoMedida = tipoMedidaService.saveTipoMedida(tipoMedidaDTO);
        return ResponseEntity.ok(nuevoTipoMedida);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TipoMedidaDTO> updateTipoMedida(@PathVariable Long id, @RequestBody TipoMedidaDTO tipoMedidaDTO) {
        TipoMedidaDTO tipoMedidaActualizado = tipoMedidaService.updateTipoMedida(id, tipoMedidaDTO);
        return ResponseEntity.ok(tipoMedidaActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteTipoMedida(@PathVariable Long id) {
        tipoMedidaService.deleteTipoMedida(id);
        return ResponseEntity.noContent().build();
    }
}
