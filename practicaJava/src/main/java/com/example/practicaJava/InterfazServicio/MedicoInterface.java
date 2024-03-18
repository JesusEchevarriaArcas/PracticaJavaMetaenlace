package com.example.practicaJava.InterfazServicio;

import com.example.practicaJava.DTO.MedicoDTO;

import java.util.List;

public interface MedicoInterface {
    public List<MedicoDTO> getAllMedicos();
    public MedicoDTO getMedicoById(Long id);
    public MedicoDTO saveMedico(MedicoDTO medicoDTO);
    public MedicoDTO updateMedico(Long id, MedicoDTO medicoDTO);
    public void deleteMedico(Long id);
}
