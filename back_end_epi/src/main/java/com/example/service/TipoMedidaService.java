package com.example.service;

import com.example.domain.TipoMedida;
import com.example.dto.TipoMedidaDTO;
import com.example.mapper.TipoMedidaMapper;
import com.example.repository.TipoMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoMedidaService {

    @Autowired
    private TipoMedidaRepository tipoMedidaRepository;

    public TipoMedidaDTO getTipoMedidaById(Long id) {
        TipoMedida tipoMedida = tipoMedidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoMedida no encontrado"));
        return TipoMedidaMapper.INSTANCE.tipoMedidaToTipoMedidaDTO(tipoMedida);
    }

    public TipoMedidaDTO saveTipoMedida(TipoMedidaDTO tipoMedidaDTO) {
        TipoMedida tipoMedida = TipoMedidaMapper.INSTANCE.tipoMedidaDTOToTipoMedida(tipoMedidaDTO);
        tipoMedida = tipoMedidaRepository.save(tipoMedida);
        return TipoMedidaMapper.INSTANCE.tipoMedidaToTipoMedidaDTO(tipoMedida);
    }

    public TipoMedidaDTO updateTipoMedida(Long id, TipoMedidaDTO tipoMedidaDTO) {
        TipoMedida tipoMedidaExistente = tipoMedidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoMedida no encontrado"));

        // Actualizar los campos necesarios
        tipoMedidaExistente.setTipo(tipoMedidaDTO.getTipo());

        tipoMedidaExistente = tipoMedidaRepository.save(tipoMedidaExistente);
        return TipoMedidaMapper.INSTANCE.tipoMedidaToTipoMedidaDTO(tipoMedidaExistente);
    }

    public void deleteTipoMedida(Long id) {
        tipoMedidaRepository.deleteById(id);
    }

    public List<TipoMedidaDTO> getAllTipoMedidas() {
        List<TipoMedida> tipoMedidas = tipoMedidaRepository.findAll();
        return tipoMedidas.stream()
                .map(TipoMedidaMapper.INSTANCE::tipoMedidaToTipoMedidaDTO)
                .collect(Collectors.toList());
    }
}
