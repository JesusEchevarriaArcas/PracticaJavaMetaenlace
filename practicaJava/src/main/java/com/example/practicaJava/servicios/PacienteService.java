package com.example.practicaJava.servicios;

import com.example.practicaJava.DTO.PacienteDTO;
import com.example.practicaJava.InterfazServicio.PacienteInterface;
import com.example.practicaJava.mapper.PacienteMapper;
import com.example.practicaJava.modelo.Paciente;
import com.example.practicaJava.repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService implements PacienteInterface {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    public List<PacienteDTO> getAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(pacienteMapper::pacienteToPacienteDTO)
                .collect(Collectors.toList());
    }

    public PacienteDTO getPacienteById(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        return paciente != null ? pacienteMapper.pacienteToPacienteDTO(paciente) : null;
    }

    public PacienteDTO savePaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteMapper.pacienteDTOToPaciente(pacienteDTO);
        return pacienteMapper.pacienteToPacienteDTO(pacienteRepository.save(paciente));
    }

    public PacienteDTO updatePaciente(Long id, PacienteDTO pacienteDTO) {
        Paciente existingPaciente = pacienteRepository.findById(id).orElse(null);
        if (existingPaciente != null) {

            existingPaciente.setNSS(pacienteDTO.getNSS());
            existingPaciente.setNumTarjeta(pacienteDTO.getNumTarjeta());
            existingPaciente.setTelefono(pacienteDTO.getTelefono());
            existingPaciente.setDireccion(pacienteDTO.getDireccion());
//            existingPaciente.setCitasPaciente(pacienteDTO.getCitas());
//            existingPaciente.setMedicos(pacienteDTO.getMedicos());
            return pacienteMapper.pacienteToPacienteDTO(pacienteRepository.save(existingPaciente));
        }
        return null;
    }

    public void deletePaciente(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
        }
    }
}
