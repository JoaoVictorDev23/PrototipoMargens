package com.tdm.prototipo_margens.serviceimpl;

import com.tdm.prototipo_margens.main.DTOs.MargemDto;
import com.tdm.prototipo_margens.main.DTOs.UsuarioDto;
import com.tdm.prototipo_margens.main.Entidades.Margem;
import com.tdm.prototipo_margens.repositories.MargemRepository;
import com.tdm.prototipo_margens.services.MargemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MargemServiceImpl implements MargemService {

    @Autowired
    MargemRepository margemRepository;

    @Override
    @Transactional
    public void createMargem(MargemDto margem){
        Margem margemExisting = this.margemRepository.findByLinha(margem.linha());
        if(margemExisting != null){
            throw new RuntimeException("Linha já cadastrada anteriormente.!");
        }
        String emailUser = SecurityContextHolder.getContext().getAuthentication().getName();

        Margem newMargem = new Margem(margem);
        newMargem.setCadastradoPor(emailUser);
        margemRepository.save(newMargem);
    }

    @Override
    public List<MargemDto> listMargem(){
        List<Margem> margemList =   margemRepository.findAll();
        return margemList.stream()
                .map(MargemDto::new)
                .collect(Collectors.toList());
    }

}

