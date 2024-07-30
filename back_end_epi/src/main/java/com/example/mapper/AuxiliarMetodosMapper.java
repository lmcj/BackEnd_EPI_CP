package com.example.mapper;

import com.example.domain.AuxiliarMetodos;
import com.example.dto.AuxiliarMetodosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuxiliarMetodosMapper {
    AuxiliarMetodosMapper INSTANCE = Mappers.getMapper(AuxiliarMetodosMapper.class);

    @Mapping(source = "metodo.id_metodo", target = "id_metodo")
    AuxiliarMetodosDTO auxiliarMetodosToAuxiliarMetodosDTO(AuxiliarMetodos auxiliarMetodos);

    @Mapping(source = "id_metodo", target = "metodo.id_metodo")
    AuxiliarMetodos auxiliarMetodosDTOToAuxiliarMetodos(AuxiliarMetodosDTO auxiliarMetodosDTO);
}
