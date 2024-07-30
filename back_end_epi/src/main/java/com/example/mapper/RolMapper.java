package com.example.mapper;

import com.example.domain.Rol;
import com.example.dto.RolDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolMapper {
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolDTO rolToRolDTO(Rol rol);

    Rol rolDTOToRol(RolDTO rolDTO);
}

