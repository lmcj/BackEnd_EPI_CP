package com.example.application.mapper;

import com.example.domain.model.ResultadoCalculo;
import com.example.domain.model.TipoMetodo;
import com.example.application.dto.TipoMetodoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TipoMetodoMapper {
    TipoMetodoMapper INSTANCE = Mappers.getMapper(TipoMetodoMapper.class);

    @Mapping(target = "resultadosCalculoIds", source = "resultadosCalculo", qualifiedByName = "mapResultadosCalculoToIds")
    TipoMetodoDTO tipoMetodoToTipoMetodoDTO(TipoMetodo tipoMetodo);

    TipoMetodo tipoMetodoDTOToTipoMetodo(TipoMetodoDTO tipoMetodoDTO);

    @Named("mapResultadosCalculoToIds")
    default List<Long> mapResultadosCalculoToIds(List<ResultadoCalculo> resultadosCalculo) {
        return resultadosCalculo == null ? new ArrayList<>() : resultadosCalculo.stream()
                .map(ResultadoCalculo::getId_resultado_calculo)
                .collect(Collectors.toList());
    }
}
