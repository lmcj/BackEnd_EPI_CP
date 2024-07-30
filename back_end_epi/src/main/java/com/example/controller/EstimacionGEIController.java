package com.example.controller;

import com.example.dto.EstimacionGEIDTO;
import com.example.service.EstimacionGEIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estimaciones-gei")
public class EstimacionGEIController {

    @Autowired
    private EstimacionGEIService estimacionGEIService;

    @GetMapping("/id/{id}")
    public EstimacionGEIDTO getEstimacionGEIById(@PathVariable Long id) {
        return estimacionGEIService.getEstimacionGEIById(id);
    }

    @PostMapping("/crear")
    public EstimacionGEIDTO createEstimacionGEI(@RequestBody EstimacionGEIDTO estimacionGEIDTO) {
        return estimacionGEIService.saveEstimacionGEI(estimacionGEIDTO);
    }

    @PutMapping("/actualizar/{id}")
    public EstimacionGEIDTO updateEstimacionGEI(@PathVariable Long id, @RequestBody EstimacionGEIDTO estimacionGEIDTO) {
        estimacionGEIDTO.setId_estimacion_gei(id);
        return estimacionGEIService.saveEstimacionGEI(estimacionGEIDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteEstimacionGEI(@PathVariable Long id) {
        estimacionGEIService.deleteEstimacionGEI(id);
    }

    @GetMapping
    public List<EstimacionGEIDTO> getAllEstimacionesGEI() {
        return estimacionGEIService.getAllEstimacionesGEI();
    }
}
