package com.tdm.prototipo_margens.services;


import com.tdm.prototipo_margens.main.DTOs.UsuarioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDto> getAllUsers();

    ResponseEntity<?> createUsers(UsuarioDto user);

    ResponseEntity<?> updateUsers(UsuarioDto user);

    ResponseEntity<?> deleteUsuario(String id);

    ResponseEntity<UsuarioDto> getUserByEmail(String email);

    ResponseEntity<?> criarPrimeiroUsuario(UsuarioDto user);

    ResponseEntity<UsuarioDto> getUserByEmail();
}
