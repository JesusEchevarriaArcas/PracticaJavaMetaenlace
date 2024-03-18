package com.example.practicaJava.controladores;


import com.example.practicaJava.InterfazServicio.PacienteInterface;
import com.example.practicaJava.DTO.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteInterface pacienteInterface;

    @GetMapping
    public List<PacienteDTO> getAllPacientes() {
        return pacienteInterface.getAllPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDTO getPacienteById(@PathVariable Long id) {
        return pacienteInterface.getPacienteById(id);
    }

    @PostMapping
    public PacienteDTO createPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteInterface.savePaciente(pacienteDTO);
    }

    @PutMapping("/{id}")
    public PacienteDTO updatePaciente(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        return pacienteInterface.updatePaciente(id, pacienteDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteInterface.deletePaciente(id);
    }
}
