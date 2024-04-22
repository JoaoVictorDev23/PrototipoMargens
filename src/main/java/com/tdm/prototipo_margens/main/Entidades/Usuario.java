package com.tdm.prototipo_margens.main.Entidades;

import com.tdm.prototipo_margens.main.DTOs.UsuarioDto;
import com.tdm.prototipo_margens.main.Enuns.perfis;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;
    
    @Column(name = "cpf")
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false)
    private perfis perfis;
    public Usuario(@Valid UsuarioDto requestUsuario){
        this.name = requestUsuario.name();
        this.email = requestUsuario.email();
        this.senha = requestUsuario.senha();
        this.perfis= requestUsuario.perfis();
        this.cpf= requestUsuario.cpf();
    }
    public Usuario(String email, String senha,perfis perfil){
        this.email = email;
        this.senha = senha;
        this.perfis = perfil;

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}

