package com.example.practicaJava.InterfazServicio;

import com.example.practicaJava.DTO.UsuarioDTO;

import java.util.List;

public interface UsuarioInterface {
    public List<UsuarioDTO> getAllUsuarios();
    public UsuarioDTO getUsuarioById(Long id);
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO);
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO);
    public void deleteUsuario(Long id);
}
