package com.example.mapper;

import com.example.domain.Credencial;
import com.example.dto.CredencialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CredencialMapper {
    CredencialMapper INSTANCE = Mappers.getMapper(CredencialMapper.class);

    CredencialDTO credencialToCredencialDTO(Credencial credencial);

    Credencial credencialDTOToCredencial(CredencialDTO credencialDTO);
}

