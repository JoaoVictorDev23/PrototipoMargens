package com.tdm.prototipo_margens.controller;



import com.tdm.prototipo_margens.main.DTOs.UsuarioDto;
import com.tdm.prototipo_margens.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControllers {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsers() {
        return ResponseEntity.ok(usuarioService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<?> createUsers(@RequestBody @Valid UsuarioDto user) {
        return usuarioService.createUsers(user);
    }

    @PutMapping
    public ResponseEntity<?> updateUsers(@RequestBody @Valid UsuarioDto user) {
        return usuarioService.updateUsers(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable String id) {
        return usuarioService.deleteUsuario(id);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioDto> getUserByEmail(@PathVariable String email) {
        return usuarioService.getUserByEmail(email);
    }

    @PostMapping("/criar-primeiro-usuario")
    public ResponseEntity<?> criarPrimeiroUsuario(@RequestBody @Valid UsuarioDto user) {
        return usuarioService.criarPrimeiroUsuario(user);
    }

    @GetMapping("/user")
    public ResponseEntity<UsuarioDto> getUserByEmail() {
        return usuarioService.getUserByEmail();
    }
}
