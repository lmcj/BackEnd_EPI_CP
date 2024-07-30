package com.example.mapper;

import com.example.domain.EstimacionGEI;
import com.example.dto.EstimacionGEIDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstimacionGEIMapper {
    EstimacionGEIMapper INSTANCE = Mappers.getMapper(EstimacionGEIMapper.class);

    @Mapping(source = "usuario.id_usuario", target = "usuarioId")
    EstimacionGEIDTO estimacionGEIToEstimacionGEIDTO(EstimacionGEI estimacionGEI);

    @Mapping(source = "usuarioId", target = "usuario.id_usuario")
    EstimacionGEI estimacionGEIDTOToEstimacionGEI(EstimacionGEIDTO estimacionGEIDTO);
}
