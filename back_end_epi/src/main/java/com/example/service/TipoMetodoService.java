package com.example.service;

import com.example.domain.TipoMetodo;
import com.example.dto.TipoMetodoDTO;
import com.example.mapper.TipoMetodoMapper;
import com.example.repository.TipoMetodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoMetodoService {

    @Autowired
    private TipoMetodoRepository tipoMetodoRepository;

    public TipoMetodoDTO getTipoMetodoById(Long id) {
        TipoMetodo tipoMetodo = tipoMetodoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoMetodo no encontrado"));
        return TipoMetodoMapper.INSTANCE.tipoMetodoToTipoMetodoDTO(tipoMetodo);
    }

    public TipoMetodoDTO saveTipoMetodo(TipoMetodoDTO tipoMetodoDTO) {
        TipoMetodo tipoMetodo = TipoMetodoMapper.INSTANCE.tipoMetodoDTOToTipoMetodo(tipoMetodoDTO);
        tipoMetodo = tipoMetodoRepository.save(tipoMetodo);
        return TipoMetodoMapper.INSTANCE.tipoMetodoToTipoMetodoDTO(tipoMetodo);
    }

    public TipoMetodoDTO updateTipoMetodo(Long id, TipoMetodoDTO tipoMetodoDTO) {
        TipoMetodo tipoMetodoExistente = tipoMetodoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoMetodo no encontrado"));

        // Actualizar los campos necesarios
        tipoMetodoExistente.setTipo(tipoMetodoDTO.getTipo());

        tipoMetodoExistente = tipoMetodoRepository.save(tipoMetodoExistente);
        return TipoMetodoMapper.INSTANCE.tipoMetodoToTipoMetodoDTO(tipoMetodoExistente);
    }

    public void deleteTipoMetodo(Long id) {
        tipoMetodoRepository.deleteById(id);
    }

    public List<TipoMetodoDTO> getAllTipoMetodos() {
        List<TipoMetodo> tipoMetodos = tipoMetodoRepository.findAll();
        return tipoMetodos.stream()
                .map(TipoMetodoMapper.INSTANCE::tipoMetodoToTipoMetodoDTO)
                .collect(Collectors.toList());
    }
}
