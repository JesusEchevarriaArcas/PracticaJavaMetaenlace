package com.example.practicaJava.servicios;


import com.example.practicaJava.DTO.CitaDTO;
import com.example.practicaJava.InterfazServicio.CitaInterface;
import com.example.practicaJava.mapper.CitaMapper;
import com.example.practicaJava.modelo.Cita;
import com.example.practicaJava.repositorios.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService implements CitaInterface {

    private final CitaRepository citaRepository;
    private final CitaMapper citaMapper;

    @Autowired
    public CitaService(CitaRepository citaRepository, CitaMapper citaMapper) {
        this.citaRepository = citaRepository;
        this.citaMapper = citaMapper;
    }

    public List<CitaDTO> getAllCitas() {
        List<Cita> citas = citaRepository.findAll();
        return citas.stream()
                .map(citaMapper::citaToCitaDTO)
                .collect(Collectors.toList());
    }

    public CitaDTO getCitaById(Long id) {
        Cita cita = citaRepository.findById(id).orElse(null);
        return cita != null ? citaMapper.citaToCitaDTO(cita) : null;
    }

    public CitaDTO saveCita(CitaDTO citaDTO) {
        Cita cita = citaMapper.citaDTOToCita(citaDTO);
        return citaMapper.citaToCitaDTO(citaRepository.save(cita));
    }

    public CitaDTO updateCita(Long id, CitaDTO citaDTO) {
        Cita existingCita = citaRepository.findById(id).orElse(null);
        if (existingCita != null) {
            existingCita.setFechaHora(citaDTO.getFechaHora());
            existingCita.setMotivoCita(citaDTO.getMotivoCita());
            existingCita.setAttribute11(citaDTO.getAttribute11());
            return citaMapper.citaToCitaDTO(citaRepository.save(existingCita));
        }
        return null;
    }

    public void deleteCita(Long id) {
        if (citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
        }
    }
}
