package com.example.practicaJava.mapper;

import com.example.practicaJava.DTO.PacienteDTO;
import com.example.practicaJava.modelo.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

//    @Mapping(source = "medicos", target = "medicos")
//    @Mapping(source = "citasPaciente", target = "citas")
    PacienteDTO pacienteToPacienteDTO(Paciente paciente);

//    @Mapping(source = "medicos", target = "medicos")
//    @Mapping(source = "citas", target = "citasPaciente")
    Paciente pacienteDTOToPaciente(PacienteDTO pacienteDTO);
}
