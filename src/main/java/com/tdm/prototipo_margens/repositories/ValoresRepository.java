package com.tdm.prototipo_margens.repositories;

import com.tdm.prototipo_margens.main.Entidades.ValoresMargem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValoresRepository extends JpaRepository<ValoresMargem, String> {

    ValoresMargem findByIdMargem(String idMargem);
}
