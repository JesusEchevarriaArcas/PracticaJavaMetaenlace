package com.example.practicaJava.mapper;

import com.example.practicaJava.DTO.CitaDTO;
import com.example.practicaJava.modelo.Cita;
import com.example.practicaJava.modelo.Diagnostico;
import com.example.practicaJava.modelo.Medico;
import com.example.practicaJava.modelo.Paciente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T13:15:40+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CitaMapperImpl implements CitaMapper {

    @Override
    public Cita citaDTOToCita(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Cita.CitaBuilder cita = Cita.builder();

        cita.paciente( citaDTOToPaciente( citaDTO ) );
        cita.medico( citaDTOToMedico( citaDTO ) );
        cita.diagnostico( citaDTOToDiagnostico( citaDTO ) );
        cita.id( citaDTO.getId() );
        cita.fechaHora( citaDTO.getFechaHora() );
        cita.motivoCita( citaDTO.getMotivoCita() );
        cita.attribute11( citaDTO.getAttribute11() );

        return cita.build();
    }

    @Override
    public CitaDTO citaToCitaDTO(Cita cita) {
        if ( cita == null ) {
            return null;
        }

        CitaDTO citaDTO = new CitaDTO();

        citaDTO.setPacienteId( citaPacienteId( cita ) );
        citaDTO.setMedicoId( citaMedicoId( cita ) );
        citaDTO.setDiagnosticoId( citaDiagnosticoId( cita ) );
        citaDTO.setId( cita.getId() );
        citaDTO.setFechaHora( cita.getFechaHora() );
        citaDTO.setMotivoCita( cita.getMotivoCita() );
        citaDTO.setAttribute11( cita.getAttribute11() );

        return citaDTO;
    }

    protected Paciente citaDTOToPaciente(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setId( citaDTO.getPacienteId() );

        return paciente;
    }

    protected Medico citaDTOToMedico(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Medico medico = new Medico();

        medico.setId( citaDTO.getMedicoId() );

        return medico;
    }

    protected Diagnostico citaDTOToDiagnostico(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Diagnostico diagnostico = new Diagnostico();

        diagnostico.setId( citaDTO.getDiagnosticoId() );

        return diagnostico;
    }

    private Long citaPacienteId(Cita cita) {
        if ( cita == null ) {
            return null;
        }
        Paciente paciente = cita.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        Long id = paciente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long citaMedicoId(Cita cita) {
        if ( cita == null ) {
            return null;
        }
        Medico medico = cita.getMedico();
        if ( medico == null ) {
            return null;
        }
        Long id = medico.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long citaDiagnosticoId(Cita cita) {
        if ( cita == null ) {
            return null;
        }
        Diagnostico diagnostico = cita.getDiagnostico();
        if ( diagnostico == null ) {
            return null;
        }
        Long id = diagnostico.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
