package com.example.mapper;

import com.example.domain.CalculoResiduos;
import com.example.dto.CalculoResiduosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CalculoResiduosMapper {
    CalculoResiduosMapper INSTANCE = Mappers.getMapper(CalculoResiduosMapper.class);

    @Mapping(source = "usuario.id_usuario", target = "usuarioId")
    @Mapping(source = "metodo.id_metodo", target = "metodoId")
    CalculoResiduosDTO calculoResiduosToCalculoResiduosDTO(CalculoResiduos calculoResiduos);

    @Mapping(source = "usuarioId", target = "usuario.id_usuario")
    @Mapping(source = "metodoId", target = "metodo.id_metodo")
    CalculoResiduos calculoResiduosDTOToCalculoResiduos(CalculoResiduosDTO calculoResiduosDTO);
}
