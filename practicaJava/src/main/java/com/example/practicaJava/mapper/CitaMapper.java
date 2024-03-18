package com.example.practicaJava.mapper;


import com.example.practicaJava.DTO.CitaDTO;
import com.example.practicaJava.modelo.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "medicoId", target = "medico.id")
    @Mapping(source = "diagnosticoId", target = "diagnostico.id")
    Cita citaDTOToCita(CitaDTO citaDTO);

    @Mapping(source = "paciente.id", target = "pacienteId")
    @Mapping(source = "medico.id", target = "medicoId")
    @Mapping(source = "diagnostico.id", target = "diagnosticoId")

    CitaDTO citaToCitaDTO(Cita cita);
}
