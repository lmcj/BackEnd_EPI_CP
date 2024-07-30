package com.example.mapper;

import com.example.domain.Persona;
import com.example.dto.PersonaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDTO personaToPersonaDTO(Persona persona);

    Persona personaDTOToPersona(PersonaDTO personaDTO);
}
