package com.example.interfaces.controller;

import com.example.application.dto.RegistroUsuarioDTO;
import com.example.application.dto.UsuarioDTO;
import com.example.application.mapper.UsuarioMapper;
import com.example.application.service.RegistroUsuarioService;
import com.example.application.service.UsuarioService;
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
        UsuarioDTO usuarioDTO = UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(registroUsuarioService.registrarUsuario(registroUsuarioDTO));
        return ResponseEntity.ok(usuarioDTO);
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

    @PutMapping("/{id}/activar")
    public UsuarioDTO activarUsuario(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.getUsuarioById(id);
        usuarioDTO.setEstado("Activo");
        return usuarioService.saveUsuario(usuarioDTO);
    }

    @GetMapping("/estado")
    public List<UsuarioDTO> getUsuarios(@RequestParam(value = "estado", required = false) String estado) {
        if (estado != null) {
            return usuarioService.getUsuariosByEstado(estado);
        } else {
            return usuarioService.getAllUsuarios();
        }
    }

}
