package com.example.mapper;

import com.example.domain.ResultadoCalculo;
import com.example.domain.TipoMedida;
import com.example.dto.TipoMedidaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

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
        return resultadosCalculo.stream()
                .map(ResultadoCalculo::getId_resultado_calculo)
                .collect(Collectors.toList());
    }
}
