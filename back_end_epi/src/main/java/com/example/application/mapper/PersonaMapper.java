package com.example.application.mapper;

import com.example.domain.model.Persona;
import com.example.application.dto.PersonaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDTO personaToPersonaDTO(Persona persona);

    Persona personaDTOToPersona(PersonaDTO personaDTO);
}
