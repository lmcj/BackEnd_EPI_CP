package com.example.service;

import com.example.domain.Persona;
import com.example.domain.Credencial;
import com.example.domain.Usuario;
import com.example.dto.RegistroUsuarioDTO;
import com.example.mapper.RegistroUsuarioMapper;
import com.example.repository.PersonaRepository;
import com.example.repository.CredencialRepository;
import com.example.repository.RolRepository;
import com.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class RegistroUsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(RegistroUsuarioService.class);

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private CredencialRepository credencialRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        logger.info("Iniciando el registro del usuario");

        // Usar el mapper para convertir DTO a entidades
        Persona persona = RegistroUsuarioMapper.INSTANCE.registroUsuarioDTOToPersona(registroUsuarioDTO);
        Credencial credencial = RegistroUsuarioMapper.INSTANCE.registroUsuarioDTOToCredencial(registroUsuarioDTO);
        Usuario usuario = RegistroUsuarioMapper.INSTANCE.registroUsuarioDTOToUsuario(registroUsuarioDTO);

        // Guardar Persona
        logger.info("Guardando la persona");
        persona = personaRepository.save(persona);

        // Cifrar la contraseña antes de guardar Credencial
        logger.info("Cifrando la contraseña y guardando la credencial");
        credencial.setEmail(persona.getEmail()); // Usar el mismo email de Persona
        credencial.setContrasenia(passwordEncoder.encode(credencial.getContrasenia()));
        credencial = credencialRepository.save(credencial);

        // Configurar y guardar Usuario
        logger.info("Configurando y guardando el usuario");
        usuario.setPersona(persona);
        usuario.setRol(rolRepository.findById(registroUsuarioDTO.getId_rol()).orElseThrow(() -> new RuntimeException("Rol no encontrado")));
        usuario.setCredencial(credencial);

        // Establecer el estado en "Revisión"
        usuario.setEstado("Revisión");

        // Establecer la fecha de registro actual
        usuario.setFecha_registro(new Timestamp(new Date().getTime()));

        Usuario savedUsuario = usuarioRepository.save(usuario);
        logger.info("Usuario registrado exitosamente");

        return savedUsuario;
    }
}
