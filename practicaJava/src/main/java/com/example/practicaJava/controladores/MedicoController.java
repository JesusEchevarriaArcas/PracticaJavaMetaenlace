package com.example.practicaJava.controladores;


import com.example.practicaJava.InterfazServicio.MedicoInterface;
import com.example.practicaJava.DTO.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoInterface medicoInterface;

    @GetMapping
    public List<MedicoDTO> getAllMedicos() {
        return medicoInterface.getAllMedicos();
    }

    @GetMapping("/{id}")
    public MedicoDTO getMedicoById(@PathVariable Long id) {
        return medicoInterface.getMedicoById(id);
    }

    @PostMapping
    public MedicoDTO createMedico(@RequestBody MedicoDTO medicoDTO) {
        return medicoInterface.saveMedico(medicoDTO);
    }

    @PutMapping("/{id}")
    public MedicoDTO updateMedico(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
        return medicoInterface.updateMedico(id, medicoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable Long id) {
        medicoInterface.deleteMedico(id);
    }
}
