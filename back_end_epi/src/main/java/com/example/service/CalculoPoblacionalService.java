package com.example.service;

import com.example.domain.CalculoPoblacional;
import com.example.domain.Usuario;
import com.example.dto.CalculoPoblacionalDTO;
import com.example.mapper.CalculoPoblacionalMapper;
import com.example.repository.CalculoPoblacionalRepository;
import com.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculoPoblacionalService {

    @Autowired
    private CalculoPoblacionalRepository calculoPoblacionalRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CalculoPoblacionalMapper calculoPoblacionalMapper;

    public CalculoPoblacionalDTO getCalculoPoblacionalById(Long id) {
        CalculoPoblacional calculoPoblacional = calculoPoblacionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cálculo poblacional no encontrado"));
        return calculoPoblacionalMapper.calculoPoblacionalToCalculoPoblacionalDTO(calculoPoblacional);
    }

    public CalculoPoblacionalDTO saveCalculoPoblacional(CalculoPoblacionalDTO calculoPoblacionalDTO) {
        CalculoPoblacional calculoPoblacional = calculoPoblacionalMapper.calculoPoblacionalDTOToCalculoPoblacional(calculoPoblacionalDTO);
        calculoPoblacional = calculoPoblacionalRepository.save(calculoPoblacional);
        return calculoPoblacionalMapper.calculoPoblacionalToCalculoPoblacionalDTO(calculoPoblacional);
    }

    public void deleteCalculoPoblacional(Long id) {
        calculoPoblacionalRepository.deleteById(id);
    }

    public List<CalculoPoblacionalDTO> getAllCalculosPoblacionales() {
        List<CalculoPoblacional> calculosPoblacionales = calculoPoblacionalRepository.findAll();
        return calculosPoblacionales.stream()
                .map(calculoPoblacionalMapper::calculoPoblacionalToCalculoPoblacionalDTO)
                .collect(Collectors.toList());
    }

    public List<CalculoPoblacionalDTO> getCalculoPoblacionalByUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return calculoPoblacionalRepository.findByUsuario(usuario)
                .stream()
                .map(calculoPoblacionalMapper::calculoPoblacionalToCalculoPoblacionalDTO)
                .collect(Collectors.toList());
    }
}
