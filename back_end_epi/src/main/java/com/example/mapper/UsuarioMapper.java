package com.example.mapper;

import com.example.domain.Usuario;
import com.example.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "persona.id_persona", target = "personaId")
    @Mapping(source = "rol.id_rol", target = "rolId")
    @Mapping(source = "credencial.id_credencial", target = "credencialId")
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    @Mapping(source = "personaId", target = "persona.id_persona")
    @Mapping(source = "rolId", target = "rol.id_rol")
    @Mapping(source = "credencialId", target = "credencial.id_credencial")
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);
}
