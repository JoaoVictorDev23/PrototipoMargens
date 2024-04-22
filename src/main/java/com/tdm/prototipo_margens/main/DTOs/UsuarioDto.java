package com.tdm.prototipo_margens.main.DTOs;

import com.tdm.prototipo_margens.main.Entidades.Usuario;
import com.tdm.prototipo_margens.main.Enuns.perfis;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDto(String id,
                         @NotBlank String name,
                         @NotNull String email,
                         @NotNull String cpf,
                         @NotNull String senha,
                         @NotNull perfis perfis
                         ) {
    public UsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getName(), usuario.getEmail(),usuario.getCpf(), usuario.getSenha(), usuario.getPerfis());
    }
}