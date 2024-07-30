package com.example.service;

import com.example.domain.Credencial;
import com.example.dto.CredencialDTO;
import com.example.mapper.CredencialMapper;
import com.example.repository.CredencialRepository;
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
