package com.example.mapper;

import com.example.domain.Metodo;
import com.example.dto.MetodoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MetodoMapper {
    MetodoMapper INSTANCE = Mappers.getMapper(MetodoMapper.class);

    MetodoDTO metodoToMetodoDTO(Metodo metodo);

    Metodo metodoDTOToMetodo(MetodoDTO metodoDTO);
}
