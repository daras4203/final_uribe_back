package com.example.API.analitica.repository;

import com.example.API.analitica.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByUsuarioId(Long usuarioId);
}