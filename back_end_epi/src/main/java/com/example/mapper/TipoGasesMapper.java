package com.example.mapper;

import com.example.domain.ResultadoCalculo;
import com.example.domain.TipoGases;
import com.example.dto.TipoGasesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TipoGasesMapper {
    TipoGasesMapper INSTANCE = Mappers.getMapper(TipoGasesMapper.class);

    @Mapping(target = "resultadosCalculoIds", source = "resultadosCalculo", qualifiedByName = "mapResultadosCalculoToIds")
    TipoGasesDTO tipoGasesToTipoGasesDTO(TipoGases tipoGases);

    TipoGases tipoGasesDTOToTipoGases(TipoGasesDTO tipoGasesDTO);

    @Named("mapResultadosCalculoToIds")
    default List<Long> mapResultadosCalculoToIds(List<ResultadoCalculo> resultadosCalculo) {
        return resultadosCalculo == null ? new ArrayList<>() : resultadosCalculo.stream()
                .map(ResultadoCalculo::getId_resultado_calculo)
                .collect(Collectors.toList());
    }
}
