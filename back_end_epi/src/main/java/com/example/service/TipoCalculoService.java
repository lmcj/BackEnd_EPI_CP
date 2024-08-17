package com.example.service;

import com.example.domain.TipoCalculo;
import com.example.dto.TipoCalculoDTO;
import com.example.mapper.TipoCalculoMapper;
import com.example.repository.TipoCalculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoCalculoService {

    @Autowired
    private TipoCalculoRepository tipoCalculoRepository;

    public TipoCalculoDTO getTipoCalculoById(Long id) {
        TipoCalculo tipoCalculo = tipoCalculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoCalculo no encontrado"));
        return TipoCalculoMapper.INSTANCE.tipoCalculoToTipoCalculoDTO(tipoCalculo);
    }

    public TipoCalculoDTO saveTipoCalculo(TipoCalculoDTO tipoCalculoDTO) {
        TipoCalculo tipoCalculo = TipoCalculoMapper.INSTANCE.tipoCalculoDTOToTipoCalculo(tipoCalculoDTO);
        tipoCalculo = tipoCalculoRepository.save(tipoCalculo);
        return TipoCalculoMapper.INSTANCE.tipoCalculoToTipoCalculoDTO(tipoCalculo);
    }

    public TipoCalculoDTO updateTipoCalculo(Long id, TipoCalculoDTO tipoCalculoDTO) {
        TipoCalculo tipoCalculoExistente = tipoCalculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoCalculo no encontrado"));

        // Actualizar los campos necesarios
        tipoCalculoExistente.setTipo(tipoCalculoDTO.getTipo());

        tipoCalculoExistente = tipoCalculoRepository.save(tipoCalculoExistente);
        return TipoCalculoMapper.INSTANCE.tipoCalculoToTipoCalculoDTO(tipoCalculoExistente);
    }

    public void deleteTipoCalculo(Long id) {
        tipoCalculoRepository.deleteById(id);
    }

    public List<TipoCalculoDTO> getAllTipoCalculos() {
        List<TipoCalculo> tipoCalculos = tipoCalculoRepository.findAll();
        return tipoCalculos.stream()
                .map(TipoCalculoMapper.INSTANCE::tipoCalculoToTipoCalculoDTO)
                .collect(Collectors.toList());
    }
}
