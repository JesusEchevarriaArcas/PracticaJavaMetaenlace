package com.example.practicaJava.controladores;


import com.example.practicaJava.InterfazServicio.CitaInterface;
import com.example.practicaJava.DTO.CitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaInterface citaInterface;

    @Autowired
    public CitaController(CitaInterface citaInterface) {
        this.citaInterface = citaInterface;
    }

    @GetMapping
    public List<CitaDTO> getAllCitas() {
        return citaInterface.getAllCitas();
    }

    @GetMapping("/{id}")
    public CitaDTO getCitaById(@PathVariable Long id) {
        return citaInterface.getCitaById(id);
    }

    @PostMapping
    public CitaDTO createCita(@RequestBody CitaDTO citaDTO) {
        return citaInterface.saveCita(citaDTO);
    }

    @PutMapping("/{id}")
    public CitaDTO updateCita(@PathVariable Long id, @RequestBody CitaDTO citaDTO) {
        return citaInterface.updateCita(id, citaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable Long id) {
        citaInterface.deleteCita(id);
    }
}
