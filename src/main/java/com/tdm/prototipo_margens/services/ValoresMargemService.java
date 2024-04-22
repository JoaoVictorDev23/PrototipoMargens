package com.tdm.prototipo_margens.services;

import com.tdm.prototipo_margens.main.DTOs.ValoresMargemDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ValoresMargemService {

    void createValores(ValoresMargemDto valoresMargemDto);
    List<ValoresMargemDto> listValores();

    ResponseEntity<ValoresMargemDto> findbyValores(String idMargem);
}
