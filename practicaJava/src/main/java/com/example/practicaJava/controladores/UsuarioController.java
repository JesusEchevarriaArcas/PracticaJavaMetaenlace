package com.example.practicaJava.controladores;


import com.example.practicaJava.InterfazServicio.UsuarioInterface;
import com.example.practicaJava.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioInterface usuarioInterface;

    @GetMapping
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioInterface.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable Long id) {
        return usuarioInterface.getUsuarioById(id);
    }

    @PostMapping
    public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioInterface.saveUsuario(usuarioDTO);
    }

    @PutMapping("/{id}")
    public UsuarioDTO updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioInterface.updateUsuario(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioInterface.deleteUsuario(id);
    }
}
