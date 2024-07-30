package com.example.mapper;

import com.example.domain.CalculoPoblacional;
import com.example.dto.CalculoPoblacionalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CalculoPoblacionalMapper {
    CalculoPoblacionalMapper INSTANCE = Mappers.getMapper(CalculoPoblacionalMapper.class);

    @Mapping(source = "usuario.id_usuario", target = "id_usuario")
    @Mapping(source = "metodo.id_metodo", target = "id_metodo")
    CalculoPoblacionalDTO calculoPoblacionalToCalculoPoblacionalDTO(CalculoPoblacional calculoPoblacional);

    @Mapping(source = "id_usuario", target = "usuario.id_usuario")
    @Mapping(source = "id_metodo", target = "metodo.id_metodo")
    CalculoPoblacional calculoPoblacionalDTOToCalculoPoblacional(CalculoPoblacionalDTO calculoPoblacionalDTO);
}
