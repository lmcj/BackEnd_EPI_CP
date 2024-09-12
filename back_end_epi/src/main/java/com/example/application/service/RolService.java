package com.example.application.service;

import com.example.domain.model.Rol;
import com.example.application.dto.RolDTO;
import com.example.application.mapper.RolMapper;
import com.example.infrastructure.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public RolDTO getRolById(Long id) {
        Rol rol = rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return RolMapper.INSTANCE.rolToRolDTO(rol);
    }

    public RolDTO saveRol(RolDTO rolDTO) {
        Rol rol = RolMapper.INSTANCE.rolDTOToRol(rolDTO);
        rol = rolRepository.save(rol);
        return RolMapper.INSTANCE.rolToRolDTO(rol);
    }

    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }

    public List<RolDTO> getAllRoles() {
        List<Rol> roles = rolRepository.findAll();
        return roles.stream()
                .map(RolMapper.INSTANCE::rolToRolDTO)
                .collect(Collectors.toList());
    }
}
