package com.example.API.analitica.controller;

import com.example.API.analitica.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO request) {

        System.out.println("EMAIL: " + request.getNombre());
        System.out.println("PASSWORD: " + request.getPassword());

        // 🔥 usuario de prueba
        if ("admin".equals(request.getEmail()) &&
                "1234".equals(request.getPassword())) {

            return ResponseEntity.ok("Login exitoso");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Credenciales incorrectas");
    }
}