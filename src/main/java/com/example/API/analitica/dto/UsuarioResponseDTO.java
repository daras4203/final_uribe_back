package com.example.API.analitica.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private String rol;
}