package com.example.API.analitica.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VentaDTO {
    private Long usuarioId;
    private List<DetalleVentaDTO> detalles;
}
