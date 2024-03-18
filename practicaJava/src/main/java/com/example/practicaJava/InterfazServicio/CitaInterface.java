package com.example.practicaJava.InterfazServicio;

import com.example.practicaJava.DTO.CitaDTO;
import com.example.practicaJava.mapper.CitaMapper;
import com.example.practicaJava.repositorios.CitaRepository;

import java.util.List;

public interface CitaInterface {
    public List<CitaDTO> getAllCitas();
    public CitaDTO getCitaById(Long id);
    public CitaDTO saveCita(CitaDTO citaDTO);
    public CitaDTO updateCita(Long id, CitaDTO citaDTO);
    public void deleteCita(Long id);
}
