package com.tdm.prototipo_margens.services;

import com.tdm.prototipo_margens.main.DTOs.ValoresMargemDto;

import java.util.List;

public interface ValoresMargemService {

    void createValores(ValoresMargemDto valoresMargemDto);
    List<ValoresMargemDto> listValores();

    ValoresMargemDto findbyValores(String idMargem);
}
