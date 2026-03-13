package com.example.API.analitica.repository;

import com.example.API.analitica.model.Producto;
import com.example.API.analitica.model.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria(Categoria categoria);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}