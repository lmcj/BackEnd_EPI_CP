package com.example.service;

import com.example.domain.AuxiliarMetodos;
import com.example.dto.AuxiliarMetodosDTO;
import com.example.mapper.AuxiliarMetodosMapper;
import com.example.repository.AuxiliarMetodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuxiliarMetodosService {

    @Autowired
    private AuxiliarMetodosRepository auxiliarMetodosRepository;

    public AuxiliarMetodosDTO getAuxiliarMetodosById(Long id) {
        AuxiliarMetodos auxiliarMetodos = auxiliarMetodosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auxiliar de métodos no encontrado"));
        return AuxiliarMetodosMapper.INSTANCE.auxiliarMetodosToAuxiliarMetodosDTO(auxiliarMetodos);
    }

    public AuxiliarMetodosDTO saveAuxiliarMetodos(AuxiliarMetodosDTO auxiliarMetodosDTO) {
        AuxiliarMetodos auxiliarMetodos = AuxiliarMetodosMapper.INSTANCE.auxiliarMetodosDTOToAuxiliarMetodos(auxiliarMetodosDTO);
        auxiliarMetodos = auxiliarMetodosRepository.save(auxiliarMetodos);
        return AuxiliarMetodosMapper.INSTANCE.auxiliarMetodosToAuxiliarMetodosDTO(auxiliarMetodos);
    }

    public void deleteAuxiliarMetodos(Long id) {
        auxiliarMetodosRepository.deleteById(id);
    }

    public List<AuxiliarMetodosDTO> getAllAuxiliaresMetodos() {
        List<AuxiliarMetodos> auxiliaresMetodos = auxiliarMetodosRepository.findAll();
        return auxiliaresMetodos.stream()
                .map(AuxiliarMetodosMapper.INSTANCE::auxiliarMetodosToAuxiliarMetodosDTO)
                .collect(Collectors.toList());
    }
}
