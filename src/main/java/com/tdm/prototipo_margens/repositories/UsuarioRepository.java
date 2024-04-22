package com.tdm.prototipo_margens.repositories;

import com.tdm.prototipo_margens.main.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByEmail(String email);
}
