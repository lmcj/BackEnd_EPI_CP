package com.example.mapper;

import com.example.domain.ResultadoCalculo;
import com.example.dto.ResultadoCalculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResultadoCalculoMapper {
    ResultadoCalculoMapper INSTANCE = Mappers.getMapper(ResultadoCalculoMapper.class);

    @Mapping(source = "calculo_gases.id_calculo_gases", target = "calculoGasesId")
    @Mapping(source = "tipo_calculo.id_tipo_calculo", target = "tipoCalculoId")
    ResultadoCalculoDTO resultadoCalculoToResultadoCalculoDTO(ResultadoCalculo resultadoCalculo);

    @Mapping(source = "calculoGasesId", target = "calculo_gases.id_calculo_gases")
    @Mapping(source = "tipoCalculoId", target = "tipo_calculo.id_tipo_calculo")
    ResultadoCalculo resultadoCalculoDTOToResultadoCalculo(ResultadoCalculoDTO resultadoCalculoDTO);
}
