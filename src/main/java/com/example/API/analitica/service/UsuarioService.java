package com.example.API.analitica.service;

import com.example.API.analitica.dto.UsuarioDTO;
import com.example.API.analitica.dto.UsuarioResponseDTO;
import com.example.API.analitica.model.Usuario;
import com.example.API.analitica.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    public UsuarioResponseDTO obtenerPorId(Long id) {
        return toResponse(usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
    }

    public UsuarioResponseDTO crear(UsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .rol(dto.getRol())
                .build();
        return toResponse(usuarioRepository.save(usuario));
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioResponseDTO toResponse(Usuario u) {
        return UsuarioResponseDTO.builder()
                .id(u.getId())
                .nombre(u.getNombre())
                .email(u.getEmail())
                .rol(u.getRol())
                .build();
    }
}