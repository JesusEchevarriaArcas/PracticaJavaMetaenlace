package com.example.practicaJava.mapper;


import com.example.practicaJava.DTO.UsuarioDTO;
import com.example.practicaJava.modelo.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "nombre", target = "nombre")
//    @Mapping(source = "apellidos", target = "apellidos")
//    @Mapping(source = "clave", target = "clave")
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "nombre", target = "nombre")
//    @Mapping(source = "apellidos", target = "apellidos")
//    @Mapping(source = "clave", target = "clave")
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);
}
