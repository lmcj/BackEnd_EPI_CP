package com.example.controller;

import com.example.dto.RegistroUsuarioDTO;
import com.example.dto.UsuarioDTO;
import com.example.mapper.UsuarioMapper;
import com.example.service.RegistroUsuarioService;
import com.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RegistroUsuarioService registroUsuarioService;

    @GetMapping("/id/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@Valid @RequestBody RegistroUsuarioDTO registroUsuarioDTO) {
        return ResponseEntity.ok(UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(registroUsuarioService.registrarUsuario(registroUsuarioDTO)));
    }

    @PutMapping("/actualizar/{id}")
    public UsuarioDTO updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO.setId_usuario(id);
        return usuarioService.saveUsuario(usuarioDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

    @GetMapping
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping("/{id}/actualizar-estado")
    public UsuarioDTO actualizarEstadoUsuario(@PathVariable Long id, @RequestParam String nuevoEstado) {
        return usuarioService.actualizarEstadoUsuario(id, nuevoEstado);
    }
}
