package com.example.application.mapper;

import com.example.domain.model.ResultadoCalculo;
import com.example.domain.model.TipoMedida;
import com.example.application.dto.TipoMedidaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TipoMedidaMapper {
    TipoMedidaMapper INSTANCE = Mappers.getMapper(TipoMedidaMapper.class);

    @Mapping(target = "resultadosCalculoIds", source = "resultadosCalculo", qualifiedByName = "mapResultadosCalculoToIds")
    TipoMedidaDTO tipoMedidaToTipoMedidaDTO(TipoMedida tipoMedida);

    TipoMedida tipoMedidaDTOToTipoMedida(TipoMedidaDTO tipoMedidaDTO);

    @Named("mapResultadosCalculoToIds")
    default List<Long> mapResultadosCalculoToIds(List<ResultadoCalculo> resultadosCalculo) {
        return resultadosCalculo == null ? new ArrayList<>() : resultadosCalculo.stream()
                .map(ResultadoCalculo::getId_resultado_calculo)
                .collect(Collectors.toList());
    }
}
