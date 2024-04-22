package com.tdm.prototipo_margens.services;

import com.tdm.prototipo_margens.main.DTOs.CriarMargemDto;
import com.tdm.prototipo_margens.main.DTOs.MargemDto;
import com.tdm.prototipo_margens.main.DTOs.UsuarioDto;
import com.tdm.prototipo_margens.main.Entidades.Margem;

import java.util.List;

public interface MargemService {

    void createMargem(CriarMargemDto margem);
    List<CriarMargemDto> listAllMargens();
    void updateMargem(String id, CriarMargemDto margemDto);
}
