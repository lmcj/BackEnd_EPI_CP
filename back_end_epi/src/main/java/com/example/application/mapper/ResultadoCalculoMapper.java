package com.example.application.mapper;

import com.example.domain.model.ResultadoCalculo;
import com.example.application.dto.ResultadoCalculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResultadoCalculoMapper {
    ResultadoCalculoMapper INSTANCE = Mappers.getMapper(ResultadoCalculoMapper.class);

    @Mapping(source = "calculo_gases.id_calculo_gases", target = "calculoGasesId")
    @Mapping(source = "tipo_calculo.id_tipo_calculo", target = "tipoCalculoId")
    @Mapping(source = "tipo_metodo.id_tipo_metodo", target = "tipoMetodoId")
    @Mapping(source = "tipo_gases.id_tipo_gases", target = "tipoGasesId")
    @Mapping(source = "tipo_medida.id_tipo_medida", target = "tipoMedidaId")
    ResultadoCalculoDTO resultadoCalculoToResultadoCalculoDTO(ResultadoCalculo resultadoCalculo);

    @Mapping(source = "calculoGasesId", target = "calculo_gases.id_calculo_gases")
    @Mapping(source = "tipoCalculoId", target = "tipo_calculo.id_tipo_calculo")
    @Mapping(source = "tipoMetodoId", target = "tipo_metodo.id_tipo_metodo")
    @Mapping(source = "tipoGasesId", target = "tipo_gases.id_tipo_gases")
    @Mapping(source = "tipoMedidaId", target = "tipo_medida.id_tipo_medida")
    ResultadoCalculo resultadoCalculoDTOToResultadoCalculo(ResultadoCalculoDTO resultadoCalculoDTO);
}
