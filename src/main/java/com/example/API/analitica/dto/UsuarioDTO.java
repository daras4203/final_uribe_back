package com.example.API.analitica.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private String nombre;
    private String email;
    private String password;
    private String rol;
}