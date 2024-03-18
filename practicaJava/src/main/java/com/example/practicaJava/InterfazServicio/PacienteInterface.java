package com.example.practicaJava.InterfazServicio;

import com.example.practicaJava.DTO.PacienteDTO;

import java.util.List;

public interface PacienteInterface {

    public List<PacienteDTO> getAllPacientes();
    public PacienteDTO getPacienteById(Long id);
    public PacienteDTO savePaciente(PacienteDTO pacienteDTO);
    public PacienteDTO updatePaciente(Long id, PacienteDTO pacienteDTO);
    public void deletePaciente(Long id);
}
