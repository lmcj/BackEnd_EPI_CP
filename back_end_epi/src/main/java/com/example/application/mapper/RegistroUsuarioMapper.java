package com.example.application.mapper;

import com.example.domain.model.Persona;
import com.example.domain.model.Credencial;
import com.example.domain.model.Usuario;
import com.example.application.dto.RegistroUsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = DateMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegistroUsuarioMapper {
    RegistroUsuarioMapper INSTANCE = Mappers.getMapper(RegistroUsuarioMapper.class);

    @Mapping(source = "tipo_documento", target = "tipo_documento")
    @Mapping(source = "numero_documento", target = "numeroDocumento")
    @Mapping(source = "fecha_nacimiento", target = "fecha_nacimiento")
    @Mapping(target = "id_persona", ignore = true) // Ignorar id_persona
    Persona registroUsuarioDTOToPersona(RegistroUsuarioDTO registroUsuarioDTO);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "contrasenia", target = "contrasenia")
    @Mapping(target = "id_credencial", ignore = true) // Ignorar id_credencial
    Credencial registroUsuarioDTOToCredencial(RegistroUsuarioDTO registroUsuarioDTO);

    @Mapping(target = "id_usuario", ignore = true) // Ignorar id_usuario
    @Mapping(target = "persona", ignore = true) // Ignorar persona, se asignará manualmente
    @Mapping(target = "rol", ignore = true) // Ignorar rol, se asignará manualmente
    @Mapping(target = "credencial", ignore = true) // Ignorar credencial, se asignará manualmente
    @Mapping(target = "estado", ignore = true) // Ignorar el estado para mantener el valor por defecto
    Usuario registroUsuarioDTOToUsuario(RegistroUsuarioDTO registroUsuarioDTO);
}
