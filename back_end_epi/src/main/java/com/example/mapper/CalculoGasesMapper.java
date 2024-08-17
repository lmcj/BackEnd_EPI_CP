package com.example.mapper;

import com.example.domain.CalculoGases;
import com.example.dto.CalculoGasesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CalculoGasesMapper {
    CalculoGasesMapper INSTANCE = Mappers.getMapper(CalculoGasesMapper.class);

    @Mapping(source = "usuario.id_usuario", target = "usuarioId")
    CalculoGasesDTO calculoGasesToCalculoGasesDTO(CalculoGases calculoGases);

    @Mapping(source = "usuarioId", target = "usuario.id_usuario")
    CalculoGases calculoGasesDTOToCalculoGases(CalculoGasesDTO calculoGasesDTO);
}
