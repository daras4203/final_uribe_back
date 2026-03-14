package com.example.API.analitica.dto;

import com.example.API.analitica.model.enums.Categoria;
import com.example.API.analitica.model.enums.Talla;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Talla talla;
    private Categoria categoria;
}