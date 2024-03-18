package com.example.practicaJava.InterfazServicio;

import com.example.practicaJava.DTO.DiagnosticoDTO;

import java.util.List;

public interface DiagnosticoInterface {
    public List<DiagnosticoDTO> getAllDiagnosticos();
    public DiagnosticoDTO getDiagnosticoById(Long id);
    public DiagnosticoDTO saveDiagnostico(DiagnosticoDTO diagnosticoDTO);
    public DiagnosticoDTO updateDiagnostico(Long id, DiagnosticoDTO diagnosticoDTO);
    public void deleteDiagnostico(Long id);
}
