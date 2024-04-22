package com.tdm.prototipo_margens.repositories;

import com.tdm.prototipo_margens.main.Entidades.Margem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MargemRepository extends JpaRepository<Margem, String> {

    Margem findByLinha(String linha);
}
