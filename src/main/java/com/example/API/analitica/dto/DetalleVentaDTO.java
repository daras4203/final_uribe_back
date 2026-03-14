package com.example.API.analitica.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleVentaDTO {
    private Long productoId;
    private Integer cantidad;
}