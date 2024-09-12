package com.example.application.mapper;

import com.example.domain.model.Credencial;
import com.example.application.dto.CredencialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CredencialMapper {
    CredencialMapper INSTANCE = Mappers.getMapper(CredencialMapper.class);

    CredencialDTO credencialToCredencialDTO(Credencial credencial);

    Credencial credencialDTOToCredencial(CredencialDTO credencialDTO);
}

