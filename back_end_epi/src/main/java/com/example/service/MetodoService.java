package com.example.service;

import com.example.domain.Metodo;
import com.example.dto.MetodoDTO;
import com.example.mapper.MetodoMapper;
import com.example.repository.MetodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetodoService {

    @Autowired
    private MetodoRepository metodoRepository;

    public MetodoDTO getMetodoById(Long id) {
        Metodo metodo = metodoRepository.findById(id).orElseThrow(() -> new RuntimeException("Método no encontrado"));
        return MetodoMapper.INSTANCE.metodoToMetodoDTO(metodo);
    }

    public MetodoDTO saveMetodo(MetodoDTO metodoDTO) {
        Metodo metodo = MetodoMapper.INSTANCE.metodoDTOToMetodo(metodoDTO);
        metodo = metodoRepository.save(metodo);
        return MetodoMapper.INSTANCE.metodoToMetodoDTO(metodo);
    }

    public void deleteMetodo(Long id) {
        metodoRepository.deleteById(id);
    }

    public List<MetodoDTO> getAllMetodos() {
        List<Metodo> metodos = metodoRepository.findAll();
        return metodos.stream()
                .map(MetodoMapper.INSTANCE::metodoToMetodoDTO)
                .collect(Collectors.toList());
    }
}
