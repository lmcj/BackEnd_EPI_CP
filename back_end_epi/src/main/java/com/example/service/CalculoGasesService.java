package com.example.service;

import com.example.domain.CalculoGases;
import com.example.dto.CalculoGasesDTO;
import com.example.mapper.CalculoGasesMapper;
import com.example.repository.CalculoGasesRepository;
import com.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculoGasesService {

    @Autowired
    private CalculoGasesRepository calculoGasesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public CalculoGasesDTO getCalculoGasesById(Long id) {
        CalculoGases calculoGases = calculoGasesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cálculo de Gases no encontrado"));
        return CalculoGasesMapper.INSTANCE.calculoGasesToCalculoGasesDTO(calculoGases);
    }

    public CalculoGasesDTO saveCalculoGases(CalculoGasesDTO calculoGasesDTO) {
        // Verifica que el ID de Usuario no sea nulo
        if (calculoGasesDTO.getUsuarioId() == null) {
            throw new IllegalArgumentException("Usuario ID no debe ser nulo");
        }

        CalculoGases calculoGases = CalculoGasesMapper.INSTANCE.calculoGasesDTOToCalculoGases(calculoGasesDTO);

        // Asegúrate de que el Usuario referenciado exista
        calculoGases.setUsuario(usuarioRepository.findById(calculoGasesDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        calculoGases = calculoGasesRepository.save(calculoGases);
        return CalculoGasesMapper.INSTANCE.calculoGasesToCalculoGasesDTO(calculoGases);
    }

    public void deleteCalculoGases(Long id) {
        calculoGasesRepository.deleteById(id);
    }

    public List<CalculoGasesDTO> getAllCalculoGases() {
        List<CalculoGases> calculoGasesList = calculoGasesRepository.findAll();
        return calculoGasesList.stream()
                .map(CalculoGasesMapper.INSTANCE::calculoGasesToCalculoGasesDTO)
                .collect(Collectors.toList());
    }
}
