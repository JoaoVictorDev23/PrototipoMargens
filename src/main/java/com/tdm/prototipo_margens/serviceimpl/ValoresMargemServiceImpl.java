package com.tdm.prototipo_margens.serviceimpl;

import com.tdm.prototipo_margens.main.DTOs.ValoresMargemDto;
import com.tdm.prototipo_margens.main.Entidades.ValoresMargem;
import com.tdm.prototipo_margens.repositories.ValoresRepository;
import com.tdm.prototipo_margens.services.ValoresMargemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValoresMargemServiceImpl implements ValoresMargemService {

    @Autowired
    ValoresRepository valoresRepository;
    @Override
    public void createValores(ValoresMargemDto valoresMargemDto){
        ValoresMargem valoresMargemExisting = this.valoresRepository.findByIdMargem(valoresMargemDto.idMargem());
        if(valoresMargemExisting != null){
            throw new RuntimeException("Valor já existente para está Linha!");
        }
        String emailUser = SecurityContextHolder.getContext().getAuthentication().getName();
        ValoresMargem  newValores = new ValoresMargem(valoresMargemDto);
        valoresRepository.save(newValores);

    }
    @Override
    public List<ValoresMargemDto> listValores() {
        return listValores();

    }

    @Override
    public ResponseEntity<ValoresMargemDto> findbyValores(String idMargem) {
        ValoresMargem valoresMargem = valoresRepository.findByIdMargem(idMargem);
        if (valoresMargem != null) {
            ValoresMargemDto valoresMargemDto = new ValoresMargemDto(valoresMargem);
            return ResponseEntity.ok(valoresMargemDto);
        } else {
            // Retornar um ResponseEntity com status not found se a entidade não for encontrada
            return ResponseEntity.notFound().build();
        }
    }



}
