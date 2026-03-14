package com.example.API.analitica.model;

import com.example.API.analitica.model.enums.Categoria;
import com.example.API.analitica.model.enums.Talla;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;

    @Enumerated(EnumType.STRING)
    private Talla talla;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;


}