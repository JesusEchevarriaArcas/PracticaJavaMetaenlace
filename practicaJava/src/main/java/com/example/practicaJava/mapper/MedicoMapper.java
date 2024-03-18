package com.example.practicaJava.mapper;

import com.example.practicaJava.DTO.MedicoDTO;
import com.example.practicaJava.modelo.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    @Mapping(source = "pacientes", target = "pacientesId")
    @Mapping(source = "citas", target = "citasId")

    MedicoDTO medicoToMedicoDTO(Medico medico);

    @Mapping(source = "pacientesId", target = "pacientes")
    @Mapping(source = "citasId", target = "citas")
    Medico medicoDTOToMedico(MedicoDTO medicoDTO);
}




