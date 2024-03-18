package com.example.practicaJava.servicios;

import com.example.practicaJava.DTO.DiagnosticoDTO;
import com.example.practicaJava.InterfazServicio.DiagnosticoInterface;
import com.example.practicaJava.mapper.DiagnosticoMapper;

import com.example.practicaJava.modelo.Diagnostico;
import com.example.practicaJava.repositorios.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosticoService implements DiagnosticoInterface {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Autowired
    private DiagnosticoMapper diagnosticoMapper;

    public List<DiagnosticoDTO> getAllDiagnosticos() {
        List<Diagnostico> diagnosticos = diagnosticoRepository.findAll();
        return diagnosticos.stream()
                .map(diagnosticoMapper::diagnosticoToDiagnosticoDTO)
                .collect(Collectors.toList());
    }

    public DiagnosticoDTO getDiagnosticoById(Long id) {
        Diagnostico diagnostico = diagnosticoRepository.findById(id).orElse(null);
        return diagnostico != null ? diagnosticoMapper.diagnosticoToDiagnosticoDTO(diagnostico) : null;
    }

    public DiagnosticoDTO saveDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = diagnosticoMapper.diagnosticoDTOToDiagnostico(diagnosticoDTO);
        diagnostico = diagnosticoRepository.save(diagnostico);
        return diagnosticoMapper.diagnosticoToDiagnosticoDTO(diagnostico);
    }

    public DiagnosticoDTO updateDiagnostico(Long id, DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnosticoExistente = diagnosticoRepository.findById(id).orElse(null);
        if (diagnosticoExistente != null) {
            Diagnostico diagnostico = diagnosticoMapper.diagnosticoDTOToDiagnostico(diagnosticoDTO);
            diagnostico.setId(id);
            diagnostico = diagnosticoRepository.save(diagnostico);
            return diagnosticoMapper.diagnosticoToDiagnosticoDTO(diagnostico);
        }
        return null;
    }

    public void deleteDiagnostico(Long id) {
        if (diagnosticoRepository.existsById(id)) {
            diagnosticoRepository.deleteById(id);
        }
    }
}
