package com.example.practicaJava.servicios;

import com.example.practicaJava.DTO.MedicoDTO;

import com.example.practicaJava.InterfazServicio.MedicoInterface;
import com.example.practicaJava.mapper.MedicoMapper;
import com.example.practicaJava.modelo.Medico;
import com.example.practicaJava.repositorios.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService implements MedicoInterface {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoMapper medicoMapper;

    public List<MedicoDTO> getAllMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream()
                .map(medicoMapper::medicoToMedicoDTO)
                .collect(Collectors.toList());
    }

    public MedicoDTO getMedicoById(Long id) {
        Medico medico = medicoRepository.findById(id).orElse(null);
        return medico != null ? medicoMapper.medicoToMedicoDTO(medico) : null;
    }

    public MedicoDTO saveMedico(MedicoDTO medicoDTO) {
        Medico medico = medicoMapper.medicoDTOToMedico(medicoDTO);
        return medicoMapper.medicoToMedicoDTO(medicoRepository.save(medico));
    }

    public MedicoDTO updateMedico(Long id, MedicoDTO medicoDTO) {
        Medico existingMedico = medicoRepository.findById(id).orElse(null);
        if (existingMedico != null) {
            existingMedico.setNumColegiado(medicoDTO.getNumColegiado());
            existingMedico.setPacientes(medicoDTO.getPacientesId());
            existingMedico.setCitas(medicoDTO.getCitasId());
            return medicoMapper.medicoToMedicoDTO(medicoRepository.save(existingMedico));
        }
        return null;
    }

    public void deleteMedico(Long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
        }
    }
}
