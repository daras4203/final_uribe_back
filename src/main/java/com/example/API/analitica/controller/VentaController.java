package com.example.API.analitica.controller;

import com.example.API.analitica.dto.VentaDTO;
import com.example.API.analitica.model.Venta;
import com.example.API.analitica.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;


    @GetMapping
    public List<Venta> listar() {
        return ventaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Venta> crear(@RequestBody VentaDTO dto) {
        return ResponseEntity.ok(ventaService.crear(dto));
    }
}