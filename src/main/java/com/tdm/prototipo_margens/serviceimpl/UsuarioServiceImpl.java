package com.tdm.prototipo_margens.serviceimpl;

import com.tdm.prototipo_margens.Errors.ErrorResponse;
import com.tdm.prototipo_margens.main.DTOs.UsuarioDto;
import com.tdm.prototipo_margens.main.Entidades.Usuario;
import com.tdm.prototipo_margens.repositories.UsuarioRepository;
import com.tdm.prototipo_margens.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<UsuarioDto> getAllUsers() {
        List<Usuario> allUsuarios = repository.findAll();
        return allUsuarios.stream()
                .map(UsuarioDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> createUsers(UsuarioDto user) {
        if (repository.findByEmail(user.email()) != null) {
            ErrorResponse  errorResponse = new ErrorResponse("Usuário já existe!");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.senha());
        Usuario newUsuario = new Usuario(user);
        newUsuario.setSenha(encryptedPassword);
        repository.save(newUsuario);
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateUsers(UsuarioDto user) {
        Optional<Usuario> optionalUsuario = repository.findById(user.id());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setName(user.name());
            usuario.setEmail(user.email());
            String encryptedPassword = new BCryptPasswordEncoder().encode(user.senha());
            usuario.setSenha(encryptedPassword);
            usuario.setPerfis(user.perfis());
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteUsuario(String id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UsuarioDto> getUserByEmail(String email) {
        Usuario usuario = repository.findByEmail(email);
        if (usuario != null) {
            UsuarioDto usuarioDTO = new UsuarioDto(usuario);
            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> criarPrimeiroUsuario(UsuarioDto user) {
        if (repository.count() > 0) {
            return ResponseEntity.badRequest().body("O primeiro usuário já foi criado.");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.senha());
        Usuario newUsuario = new Usuario(user);
        newUsuario.setSenha(encryptedPassword);
        repository.save(newUsuario);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UsuarioDto> getUserByEmail() {
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = repository.findByEmail(emailUsuario);
        if (usuario != null) {
            UsuarioDto usuarioDTO = new UsuarioDto(usuario);
            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}