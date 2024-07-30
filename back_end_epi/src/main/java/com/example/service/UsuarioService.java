package com.example.service;

import com.example.domain.Usuario;
import com.example.dto.UsuarioDTO;
import com.example.mapper.UsuarioMapper;
import com.example.repository.PersonaRepository;
import com.example.repository.RolRepository;
import com.example.repository.CredencialRepository;
import com.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private CredencialRepository credencialRepository;

    public UsuarioDTO getUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
    }

    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        // Verifica que los IDs no sean nulos
        if (usuarioDTO.getPersonaId() == null || usuarioDTO.getRolId() == null || usuarioDTO.getCredencialId() == null) {
            throw new IllegalArgumentException("Persona ID, Rol ID y Credencial ID no deben ser nulos");
        }

        Usuario usuario = UsuarioMapper.INSTANCE.usuarioDTOToUsuario(usuarioDTO);

        // Asegúrate de que las entidades referenciadas existan
        usuario.setPersona(personaRepository.findById(usuarioDTO.getPersonaId()).orElseThrow(() -> new RuntimeException("Persona no encontrada")));
        usuario.setRol(rolRepository.findById(usuarioDTO.getRolId()).orElseThrow(() -> new RuntimeException("Rol no encontrado")));
        usuario.setCredencial(credencialRepository.findById(usuarioDTO.getCredencialId()).orElseThrow(() -> new RuntimeException("Credencial no encontrada")));

        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper.INSTANCE::usuarioToUsuarioDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO actualizarEstadoUsuario(Long idUsuario, String nuevoEstado) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setEstado(nuevoEstado);
        usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
    }
}
