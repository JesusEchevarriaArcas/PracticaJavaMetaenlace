package com.example.practicaJava.servicios;

import com.example.practicaJava.DTO.UsuarioDTO;
import com.example.practicaJava.InterfazServicio.UsuarioInterface;
import com.example.practicaJava.mapper.UsuarioMapper;
import com.example.practicaJava.modelo.Usuario;
import com.example.practicaJava.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UsuarioInterface {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::usuarioToUsuarioDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuario != null ? usuarioMapper.usuarioToUsuarioDTO(usuario) : null;
    }

    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.usuarioDTOToUsuario(usuarioDTO);
        return usuarioMapper.usuarioToUsuarioDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario existingUsuario = usuarioRepository.findById(id).orElse(null);
        if (existingUsuario != null) {
            existingUsuario.setNombre(usuarioDTO.getNombre());
            existingUsuario.setApellidos(usuarioDTO.getApellidos());
            existingUsuario.setClave(usuarioDTO.getClave());
            return usuarioMapper.usuarioToUsuarioDTO(usuarioRepository.save(existingUsuario));
        }
        return null;
    }

    public void deleteUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
    }
}
