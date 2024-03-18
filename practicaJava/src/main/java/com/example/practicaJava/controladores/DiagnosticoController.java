package com.example.practicaJava.controladores;


import com.example.practicaJava.InterfazServicio.DiagnosticoInterface;
import com.example.practicaJava.DTO.DiagnosticoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoInterface diagnosticoInterface;

    @GetMapping
    public List<DiagnosticoDTO> getAllDiagnosticos() {
        return diagnosticoInterface.getAllDiagnosticos();
    }

    @GetMapping("/{id}")
    public DiagnosticoDTO getDiagnosticoById(@PathVariable Long id) {
        return diagnosticoInterface.getDiagnosticoById(id);
    }

    @PostMapping
    public DiagnosticoDTO createDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        return diagnosticoInterface.saveDiagnostico(diagnosticoDTO);
    }

    @PutMapping("/{id}")
    public DiagnosticoDTO updateDiagnostico(@PathVariable Long id, @RequestBody DiagnosticoDTO diagnosticoDTO) {
        return diagnosticoInterface.updateDiagnostico(id, diagnosticoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagnostico(@PathVariable Long id) {
        diagnosticoInterface.deleteDiagnostico(id);
    }
}
