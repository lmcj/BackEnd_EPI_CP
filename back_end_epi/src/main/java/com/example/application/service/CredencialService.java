package com.example.application.service;

import com.example.domain.model.Credencial;
import com.example.application.dto.CredencialDTO;
import com.example.application.mapper.CredencialMapper;
import com.example.infrastructure.repository.CredencialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CredencialService {

    @Autowired
    private CredencialRepository credencialRepository;

    public CredencialDTO getCredencialById(Long id) {
        Credencial credencial = credencialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credencial no encontrada"));
        return CredencialMapper.INSTANCE.credencialToCredencialDTO(credencial);
    }

    public CredencialDTO saveCredencial(CredencialDTO credencialDTO) {
        Credencial credencial = CredencialMapper.INSTANCE.credencialDTOToCredencial(credencialDTO);
        credencial = credencialRepository.save(credencial);
        return CredencialMapper.INSTANCE.credencialToCredencialDTO(credencial);
    }

    public void deleteCredencial(Long id) {
        credencialRepository.deleteById(id);
    }

    public List<CredencialDTO> getAllCredenciales() {
        List<Credencial> credenciales = credencialRepository.findAll();
        return credenciales.stream()
                .map(CredencialMapper.INSTANCE::credencialToCredencialDTO)
                .collect(Collectors.toList());
    }
}
