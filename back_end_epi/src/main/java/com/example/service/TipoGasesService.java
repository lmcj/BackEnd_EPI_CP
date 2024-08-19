package com.example.service;

import com.example.domain.TipoGases;
import com.example.dto.TipoGasesDTO;
import com.example.mapper.TipoGasesMapper;
import com.example.repository.TipoGasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoGasesService {

    @Autowired
    private TipoGasesRepository tipoGasesRepository;

    public TipoGasesDTO getTipoGasesById(Long id) {
        TipoGases tipoGases = tipoGasesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoGases no encontrado"));
        return TipoGasesMapper.INSTANCE.tipoGasesToTipoGasesDTO(tipoGases);
    }

    public TipoGasesDTO saveTipoGases(TipoGasesDTO tipoGasesDTO) {
        TipoGases tipoGases = TipoGasesMapper.INSTANCE.tipoGasesDTOToTipoGases(tipoGasesDTO);
        tipoGases = tipoGasesRepository.save(tipoGases);
        return TipoGasesMapper.INSTANCE.tipoGasesToTipoGasesDTO(tipoGases);
    }

    public TipoGasesDTO updateTipoGases(Long id, TipoGasesDTO tipoGasesDTO) {
        TipoGases tipoGasesExistente = tipoGasesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoGases no encontrado"));

        // Actualizar los campos necesarios
        tipoGasesExistente.setTipo(tipoGasesDTO.getTipo());

        tipoGasesExistente = tipoGasesRepository.save(tipoGasesExistente);
        return TipoGasesMapper.INSTANCE.tipoGasesToTipoGasesDTO(tipoGasesExistente);
    }

    public void deleteTipoGases(Long id) {
        tipoGasesRepository.deleteById(id);
    }

    public List<TipoGasesDTO> getAllTipoGases() {
        List<TipoGases> tipoGasesList = tipoGasesRepository.findAll();
        return tipoGasesList.stream()
                .map(TipoGasesMapper.INSTANCE::tipoGasesToTipoGasesDTO)
                .collect(Collectors.toList());
    }
}
