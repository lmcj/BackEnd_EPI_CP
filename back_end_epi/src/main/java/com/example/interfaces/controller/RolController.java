package com.example.interfaces.controller;

import com.example.application.dto.RolDTO;
import com.example.application.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/id/{id}")
    public RolDTO getRolById(@PathVariable Long id) {
        return rolService.getRolById(id);
    }

    @PostMapping("/crear")
    public RolDTO createRol(@RequestBody RolDTO rolDTO) {
        return rolService.saveRol(rolDTO);
    }

    @PutMapping("/actualizar/{id}")
    public RolDTO updateRol(@PathVariable Long id, @RequestBody RolDTO rolDTO) {
        rolDTO.setId_rol(id);
        return rolService.saveRol(rolDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
    }

    @GetMapping
    public List<RolDTO> getAllRoles() {
        return rolService.getAllRoles();
    }
}
