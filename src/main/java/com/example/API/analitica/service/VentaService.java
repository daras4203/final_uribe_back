package com.example.API.analitica.service;

import com.example.API.analitica.dto.VentaDTO;
import com.example.API.analitica.model.Venta;
import com.example.API.analitica.model.*;
import com.example.API.analitica.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;

    public List<Venta> listarTodas() {
        return ventaRepository.findAll();
    }

    public Venta obtenerPorId(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    public Venta crear(VentaDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Venta venta = Venta.builder()
                .usuario(usuario)
                .fecha(LocalDateTime.now())
                .build();

        List<DetalleVenta> detalles = dto.getDetalles().stream().map(d -> {
            Producto producto = productoRepository.findById(d.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            return DetalleVenta.builder()
                    .venta(venta)
                    .producto(producto)
                    .cantidad(d.getCantidad())
                    .precioUnitario(producto.getPrecio())
                    .build();
        }).collect(Collectors.toList());

        double total = detalles.stream()
                .mapToDouble(d -> d.getCantidad() * d.getPrecioUnitario()).sum();

        venta.setDetalles(detalles);
        venta.setTotal(total);

        return ventaRepository.save(venta);
    }
}