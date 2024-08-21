package com.example.mapper;

import com.example.domain.ResultadoCalculo;
import com.example.domain.TipoCalculo;
import com.example.dto.TipoCalculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TipoCalculoMapper {
    TipoCalculoMapper INSTANCE = Mappers.getMapper(TipoCalculoMapper.class);

    @Mapping(target = "resultadosCalculoIds", source = "resultadosCalculo", qualifiedByName = "mapResultadosCalculoToIds")
    TipoCalculoDTO tipoCalculoToTipoCalculoDTO(TipoCalculo tipoCalculo);

    TipoCalculo tipoCalculoDTOToTipoCalculo(TipoCalculoDTO tipoCalculoDTO);

    // Este método adicional convierte la lista de objetos ResultadoCalculo a una lista de IDs
    @Named("mapResultadosCalculoToIds")
    default List<Long> mapResultadosCalculoToIds(List<ResultadoCalculo> resultadosCalculo) {
        return resultadosCalculo == null ? new ArrayList<>() : resultadosCalculo.stream()
                .map(ResultadoCalculo::getId_resultado_calculo)
                .collect(Collectors.toList());
    }
}
