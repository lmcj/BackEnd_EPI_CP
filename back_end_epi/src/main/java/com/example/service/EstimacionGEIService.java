package com.example.service;

import com.example.domain.EstimacionGEI;
import com.example.dto.EstimacionGEIDTO;
import com.example.mapper.EstimacionGEIMapper;
import com.example.repository.EstimacionGEIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstimacionGEIService {

    @Autowired
    private EstimacionGEIRepository estimacionGEIRepository;

    public EstimacionGEIDTO getEstimacionGEIById(Long id) {
        EstimacionGEI estimacionGEI = estimacionGEIRepository.findById(id).orElseThrow(() -> new RuntimeException("Estimación GEI no encontrada"));
        return EstimacionGEIMapper.INSTANCE.estimacionGEIToEstimacionGEIDTO(estimacionGEI);
    }

    public EstimacionGEIDTO saveEstimacionGEI(EstimacionGEIDTO estimacionGEIDTO) {
        EstimacionGEI estimacionGEI = EstimacionGEIMapper.INSTANCE.estimacionGEIDTOToEstimacionGEI(estimacionGEIDTO);
        estimacionGEI = estimacionGEIRepository.save(estimacionGEI);
        return EstimacionGEIMapper.INSTANCE.estimacionGEIToEstimacionGEIDTO(estimacionGEI);
    }

    public void deleteEstimacionGEI(Long id) {
        estimacionGEIRepository.deleteById(id);
    }

    public List<EstimacionGEIDTO> getAllEstimacionesGEI() {
        List<EstimacionGEI> estimacionesGEI = estimacionGEIRepository.findAll();
        return estimacionesGEI.stream()
                .map(EstimacionGEIMapper.INSTANCE::estimacionGEIToEstimacionGEIDTO)
                .collect(Collectors.toList());
    }
}
