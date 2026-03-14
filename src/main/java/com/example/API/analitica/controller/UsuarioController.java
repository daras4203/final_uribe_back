package com.example.API.analitica.controller;

import com.example.API.analitica.dto.UsuarioDTO;
import com.example.API.analitica.dto.UsuarioResponseDTO;
import com.example.API.analitica.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crear(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.crear(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}