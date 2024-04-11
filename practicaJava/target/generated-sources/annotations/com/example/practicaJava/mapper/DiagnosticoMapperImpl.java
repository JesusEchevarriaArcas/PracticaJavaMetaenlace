package com.example.practicaJava.mapper;

import com.example.practicaJava.DTO.DiagnosticoDTO;
import com.example.practicaJava.modelo.Cita;
import com.example.practicaJava.modelo.Diagnostico;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-10T14:43:34+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DiagnosticoMapperImpl implements DiagnosticoMapper {

    @Override
    public Diagnostico diagnosticoDTOToDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        if ( diagnosticoDTO == null ) {
            return null;
        }

        Diagnostico diagnostico = new Diagnostico();

        diagnostico.setCita( diagnosticoDTOToCita( diagnosticoDTO ) );
        diagnostico.setId( diagnosticoDTO.getId() );
        diagnostico.setValoracionEspecialista( diagnosticoDTO.getValoracionEspecialista() );
        diagnostico.setEnfermedad( diagnosticoDTO.getEnfermedad() );

        return diagnostico;
    }

    @Override
    public DiagnosticoDTO diagnosticoToDiagnosticoDTO(Diagnostico diagnostico) {
        if ( diagnostico == null ) {
            return null;
        }

        DiagnosticoDTO diagnosticoDTO = new DiagnosticoDTO();

        diagnosticoDTO.setCitaId( diagnosticoCitaId( diagnostico ) );
        diagnosticoDTO.setId( diagnostico.getId() );
        diagnosticoDTO.setValoracionEspecialista( diagnostico.getValoracionEspecialista() );
        diagnosticoDTO.setEnfermedad( diagnostico.getEnfermedad() );

        return diagnosticoDTO;
    }

    protected Cita diagnosticoDTOToCita(DiagnosticoDTO diagnosticoDTO) {
        if ( diagnosticoDTO == null ) {
            return null;
        }

        Cita.CitaBuilder cita = Cita.builder();

        cita.id( diagnosticoDTO.getCitaId() );

        return cita.build();
    }

    private Long diagnosticoCitaId(Diagnostico diagnostico) {
        if ( diagnostico == null ) {
            return null;
        }
        Cita cita = diagnostico.getCita();
        if ( cita == null ) {
            return null;
        }
        Long id = cita.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
